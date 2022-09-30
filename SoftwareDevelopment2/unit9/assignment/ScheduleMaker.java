/**
 * This program given a list of courses will create the most optimal schedule with the 
 * most amount of courses
 * 
 * Author: Chris Shepard
 */

package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScheduleMaker {

    /**
     * This method houses the actual algorithm that makes the schedule
     * it uses a greey algorithm
     * @param courses
     * @return list of courses
     */
    public static List<Course> makeSchedule(List<Course> courses){
        //sort the courses by starting time
        // pick the next course avalible at the ending time of the current course
        // this next course should have the shortest duration and then add
        // it to the courseList, repeat until the courses have all been looked through
        Collections.sort(courses, new CourseComparator());
        List<Course> courseList = new ArrayList<>();

        for(Course c : courses){
            courseList.add(c);
        }

        for(int i = 0; i < courseList.size() - 1; i++){
            if(courseList.get(i).getStart() == courseList.get(i + 1).getStart()){
                if(courseList.get(i).duration() > courseList.get(i + 1).duration()){
                    courseList.remove(i);
                    i--;
                }
            }
        }
        
        for(int i = 0; i < courseList.size() - 1; i++){
            if(courseList.get(i).getEnd() > courseList.get(i + 1).getStart()){
                courseList.remove(i + 1);
            }
        }
        return courseList;
    }

    /**
     * this method is used for testing purposes, it creates a list of courses and calls the
     * function that makes the optimal schedule
     * @param args
     */
    public static void main(String[] args) {
        List<Course> courses = Course.exampleCourses();
        System.out.println(makeSchedule(courses));
    }
}