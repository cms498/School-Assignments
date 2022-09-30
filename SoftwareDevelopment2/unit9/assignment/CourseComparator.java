/**
 * This program houses the comparator for the courses, it helps in sorting
 * the courses by start time, with the lowest coming first
 * 
 * Author: Chris Shepard
 */

package assignment;

import java.util.Comparator;

public class CourseComparator implements Comparator<Course>{

    /**
     * compares two courses starttimes, with the smaller coming first
     */
    @Override
    public int compare(Course c1, Course c2) {
        int c1StartTime = c1.getStart();
        int c2StartTime = c2.getStart();
        int difference = c2StartTime - c1StartTime;
        if(difference == 0){
            return 0;
        } else if(difference < 0){
            return 1;
        } else {
            return -1;
        }
    }
}