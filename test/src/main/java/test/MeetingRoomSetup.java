package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomSetup {
	
	  record Meeting(int start, int finish, int index) {}
	  
	  
	  public List<Meeting> schduleMeetings(List<Meeting> meetings) {
		  List<Meeting> scheuledMeetings = new ArrayList<>();
		  meetings.sort(Comparator.comparing(Meeting::finish));
		  
		  int lastFinish = meetings.get(0).finish;
		  scheuledMeetings.add(meetings.get(0));
		  for(int i=1; i<meetings.size()-1;i++) {
			  Meeting meeting = meetings.get(i);
			  if(meeting.start > lastFinish) {
				  scheuledMeetings.add(meeting);
				  lastFinish = meeting.finish;
			  }
		  }
		  return scheuledMeetings;
	  }
	  
	  public static void main(String[] args) {
		  
		  MeetingRoomSetup meetingRoomSetup = new MeetingRoomSetup();
		  List<Meeting> meetings = new ArrayList<>();
		  int[] s = {1, 3, 0, 5, 8, 5}; 
		  int[] f = {2, 4, 6, 7, 9, 9};
		  
		  for(int i=0; i < s.length; i++) {
			  meetings.add(new Meeting(s[i], f[i], i));
		  }
		  
		  List<Meeting> scheuledMeetings = meetingRoomSetup.schduleMeetings(meetings);
		  scheuledMeetings.forEach( meeting -> System.out.println(meeting.start + "  " + meeting.finish));
	  }
	
	  
}