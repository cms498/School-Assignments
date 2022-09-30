#include "HomeSecurity.h"
#include <iostream>
#include <string>

using namespace std;

Room::Room()
    : roomId(0), lastEvent(0), totalEvents(0), oldestEvent(0)
{
    HomeEvent* events[MAXEVENTS];
}

//Receives the sensor data in a vector (each element is a string)
//Extract the data from vector elements per the spec
//Call the appropriate child class (of HomeEvent) SetData method to tell that class to process the event
void Room::LoadData(vector<string> data)
{
    //ROOM,SID,HH:MM:SS,TYPE[,VALUE]
    //Your code here
    roomId = stoi(data[0]);
    int sensorId = stoi(data[1]);
    string timeStamp = data[2];
    int eventType = stoi(data[3]);
    int sensorValue;

    if(eventType != 9 && eventType != 3){
        sensorValue = stoi(data[4]);
    }
    if(eventType == 1){
        totalEvents++;
        TemperatureEvent* temperatureEvent = new TemperatureEvent();
        temperatureEvent -> SetData(roomId, timeStamp, eventType, sensorId, sensorValue);
        if(totalEvents > MAXEVENTS){

            delete events[oldestEvent];
            events[oldestEvent] = temperatureEvent;
            oldestEvent++;
            lastEvent++;
            if(oldestEvent >= MAXEVENTS){
                oldestEvent = 0;
            }
            if(lastEvent >= MAXEVENTS){
                lastEvent = 0;
            } 

        } else {
            events[lastEvent] = temperatureEvent;
            lastEvent++;
        }
    } else if(eventType == 2){
        totalEvents++;
        COEvent* coEvent = new COEvent();
        coEvent -> SetData(roomId, timeStamp, eventType, sensorId, sensorValue);
        if(totalEvents > MAXEVENTS){

            delete events[oldestEvent];
            events[oldestEvent] = coEvent;
            oldestEvent++;
            lastEvent++;
            if(oldestEvent >= MAXEVENTS){
                oldestEvent = 0;
            }
            if(lastEvent >= MAXEVENTS){
                lastEvent = 0;
            }

        } else {
            events[lastEvent] = coEvent;
            lastEvent++;
        }
    } else if(eventType == 3){
        totalEvents++;
        IntruderEvent* intruderEvent = new IntruderEvent();
        intruderEvent -> SetData(roomId, timeStamp, eventType, sensorId, sensorValue);
        intruderEvent -> Print(roomId);
        if(totalEvents > MAXEVENTS){

            delete events[oldestEvent];
            events[oldestEvent] = intruderEvent;
            oldestEvent++;
            lastEvent++;
            if(oldestEvent >= MAXEVENTS){
                oldestEvent = 0;
            }
            if(lastEvent >= MAXEVENTS){
                lastEvent = 0;
            }

        } else {
            events[lastEvent] = intruderEvent;
            lastEvent++;
        }
    } else if(eventType == 9){
        PrintEvents(roomId, timeStamp, sensorId, eventType);
    }
}

//Use this method to print all the events for the room
void Room::PrintEvents(int _roomId, string time, int sensor, int eventType)
{
    cout <<  "*****" << endl;
    cout << "Home Security System: Room " << _roomId << " @ " << time << endl;
    cout << "Triggered by sensor " << sensor << endl;
    cout << totalEvents << " total room events" << endl;
    for(HomeEvent* &event : events){
        event -> HomeEvent::Print(_roomId);
    }
}

HomeEvent::HomeEvent()
    : timeStamp(""), eventId(0), sensorId(0), sensorValue(0){}

//Base class event to recieve data about an event
void HomeEvent::SetData(int room, string time, int _eventId, int _sensorId, int _sensorValue)
{
    timeStamp = time;
    eventId = _eventId;
    sensorId = _sensorId;
    sensorValue = _sensorValue;
    int roomValue = room;
}

string HomeEvent::GetTime()
{
    return timeStamp;
}
int HomeEvent::GetEventId()
{
    return eventId;
}
int HomeEvent::GetSensorId()
{
    return sensorId;
}

int HomeEvent::GetSensorValue() { return sensorValue;}

//Example of print method.  Subclasses will override and format for their own purposes
void HomeEvent::Print(int room)
{
    string output = "";
    string ending = "";
    if(eventId == 1){
        output = " temperature reading ";
        ending = " degrees ";
    }
    if(eventId == 2){
        output = " carbon monoxide reading ";
        ending = " PPB ";
    }
    if(eventId == 3){
        output = " intruder event ";
    }
    cout << "Sensor " << sensorId << " @ " << timeStamp << output;
    if (eventId != 3) {
        cout << sensorValue;
    }
    cout << ending << endl;    
}

//Sub-classed method for receiving a temperature event
void TemperatureEvent::SetData(int room, string time, int _eventId, int _sensorId, int _sensorValue)
{
    timeStamp = time;
    eventId = _eventId;
    sensorId = _sensorId;
    sensorValue = _sensorValue;
    int roomValue = room;
}

//Subclassed method to print a temperature event
void TemperatureEvent::Print(int room)
{
    cout << "Temperature Alert @ " << timeStamp << ": room " << room 
    << " / sensor " << sensorId << " / " << sensorValue << " degrees" << endl;
}

//Sub-classed method for receiving a CO event
void COEvent::SetData(int room, string time, int _eventId, int _sensorId, int _sensorValue)
{
    timeStamp = time;
    eventId = _eventId;
    sensorId = _sensorId;
    sensorValue = _sensorValue;
    int roomValue = room;
}


//Sub-classed method for printing a CO event
void COEvent::Print(int room)
{
    cout << "Carbon Monoxide Alert @ " << timeStamp << ": room " << room 
    << " / sensor " << sensorId << " / " << sensorValue << " PPB" << endl;
}


//Sub-classed method for receiving an Intruder event
void IntruderEvent::SetData(int room, string time, int _eventId, int _sensorId, int _sensorValue)
{
    eventId = _eventId;
    sensorId = _sensorId;
    sensorValue = _sensorValue;
    timeStamp = time;    
    int roomValue = room;
}

//Subclassed method for printing an intruder event
void IntruderEvent::Print(int room)
{
   cout << "Intruder alert @ " << timeStamp << ": room " << room << " / sensor " << sensorId << "." << endl;
}
