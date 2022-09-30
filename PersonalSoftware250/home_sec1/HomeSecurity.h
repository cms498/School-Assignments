#include <string>
#include <vector>
using namespace std;

#define MAXEVENTS 5


//Base class.  Each specific event should be subclassed and customized as needed
class HomeEvent
{
    public:
    HomeEvent();
    virtual void Print(int room);
    //The basic 'get' methods for the internal data
    string GetTime();
    int GetEventId();
    int GetSensorId();
    int GetSensorValue();
    //The basic 'set' method to populate the data
    virtual void SetData(int room, string time, int eventId, int sensorId, int sensorValue);
    protected:
    string timeStamp;
    int eventId;
    int sensorId;
    int sensorValue;
};

class TemperatureEvent: public HomeEvent
{
    public:
    const int minTemp = 50;
    const int maxTemp = 110;
    void Print(int room);//Print Temperature data per the spec
    void SetData(int room, string time, int eventId, int sensorId, int sensorValue);
};

class COEvent: public HomeEvent
{
    public:
    const int maxCO = 3000;
    void Print(int room);//Print CO Event data per the spec
    void SetData(int room, string time, int eventId, int sensorId, int sensorValue);
};

class IntruderEvent: public HomeEvent
{
    public:
    void Print(int room);//Print Intruder data per the spec
    void SetData(int room, string time, int eventId, int sensorId, int sensorValue);
};

class Room
{
    public:
    Room();
    void LoadData(vector<string> data);//Room and event data is in the data per the spec.
    //Print Events will print all the events for the room
    //The sensor/ eventtype that triggers the print command is passed into the method
    void PrintEvents(int _roomId, string time, int sensorId, int eventType);
    protected:
    HomeEvent* events[MAXEVENTS];//Array of pointers to HomeEvent
    int roomId;
    int lastEvent;
    int totalEvents;
    int oldestEvent;
};
