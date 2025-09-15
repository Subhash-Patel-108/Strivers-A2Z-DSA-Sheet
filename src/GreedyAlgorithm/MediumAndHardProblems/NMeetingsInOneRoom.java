package GreedyAlgorithm.MediumAndHardProblems;

import java.util.ArrayList;

public class NMeetingsInOneRoom {
    public static class Solution {
        // Represents a meeting with start and end times
        private static class Meeting {
            public int startTime;
            public int endTime;

            // Constructor to initialize meeting times
            public Meeting(int startTime, int endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }
        }

        // Finds the maximum number of non-overlapping meetings that can be scheduled
        public static int maximumMeetings(int[] startTimes, int[] endTimes) {
            // Handle edge cases: return 0 if arrays are null or have different lengths
            if (startTimes == null || endTimes == null || startTimes.length != endTimes.length) {
                return 0;
            }

            // Create list of meetings from start and end times
            ArrayList<Meeting> meetings = new ArrayList<>();
            for (int i = 0; i < startTimes.length; i++) {
                meetings.add(new Meeting(startTimes[i], endTimes[i]));
            }

            // Sort meetings by end time to prioritize earlier-ending meetings
            meetings.sort((a, b) -> Integer.compare(a.endTime, b.endTime));

            return countMaxNonOverlappingMeetings(meetings);
        }

        // Counts the maximum number of non-overlapping meetings
        private static int countMaxNonOverlappingMeetings(ArrayList<Meeting> meetings) {
            // Return 0 if no meetings exist
            if (meetings.isEmpty()) {
                return 0;
            }

            int meetingCount = 1; // First meeting is always included
            int lastEndTime = meetings.get(0).endTime;

            // Iterate through sorted meetings to select non-overlapping ones
            for (int i = 1; i < meetings.size(); i++) {
                int currentStartTime = meetings.get(i).startTime;
                int currentEndTime = meetings.get(i).endTime;

                // Include meeting if it starts after the last selected meeting ends
                if (currentStartTime > lastEndTime) {
                    lastEndTime = currentEndTime;
                    meetingCount++;
                }
            }

            return meetingCount;
        }
    }

    public static void main(String[] args) {

    }
}
