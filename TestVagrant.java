package interviewPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestVagrant {
	
	//Method accepts predefined data that could be passed from main method
	static Map<String, List<String>> playListMethodStaticUser(String user,String songs[]) {
		
		List<String> songQ = new ArrayList<>();         
		Map<String, List<String>> userPlayListMap = new HashMap<String, List<String>>();
		
		if(user.isEmpty() || songs.length==0)
		{
   		 songQ.add("user and song is mandatory");
   		userPlayListMap.put("user and song is missing", songQ);
   		 return userPlayListMap;
   	 	}

		for(String song:songs) {
			int count = songQ.size();
			if(count <3) {
				if(songQ.contains(song)) {
					songQ.remove(songQ.indexOf(song));
					songQ.add(song);
				}else {
					songQ.add(song);
				}
				
			}else {
				if(songQ.contains(song)) {
					songQ.remove(songQ.indexOf(song));
					songQ.add(song);
   			 }else {
   				songQ.remove(0);
				songQ.add(song);
   			 }
			}
		}
		userPlayListMap.put(user, songQ);
		return userPlayListMap;
		 
	}
	
	//Method can accepts data during run time for multiple users and songs
	static void playListMethodDynamicUser() {
		
		List<String> songQ = new ArrayList<>();
		Map<String, List<String>> userPlayListMap = new HashMap<String, List<String>>();
		
		String user="";
		String song="";
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 10; i++) { 
			boolean shouldContinueUser = true;
			while(shouldContinueUser == true) {
				System.out.println("enter user ");
	        	 user = in.nextLine();
	        	 if(user.isEmpty()) {
	        		 System.out.println("Alert!user is mandatory ");
	        		 shouldContinueUser = true; 
	        	 }else {
	        		 shouldContinueUser = false;
	        	 }
			}
			boolean shouldContinueSong = true;
			while(shouldContinueSong == true) {
				System.out.println("enter song ");
				song = in.nextLine();
	        	 if(song.isEmpty()) {
	        		 System.out.println("Alert!song is mandatory ");
	        		 shouldContinueSong = true; 
	        	 }else {
	        		 shouldContinueSong = false;
	        	 }
			}
        	 if(userPlayListMap.containsKey(user)) {
        		 if(userPlayListMap.get(user).size()<3) {
        			 if(userPlayListMap.get(user).contains(song)) {
        				 userPlayListMap.get(user).remove(song);
        				 userPlayListMap.get(user).add(song);
        			 }else {
        				 userPlayListMap.get(user).add(song);
        			 }
        				 
        			 }else {
        				 if(userPlayListMap.get(user).contains(song)) {
            				 userPlayListMap.get(user).remove(song);
            				 userPlayListMap.get(user).add(song);
            			 }else {
            				 userPlayListMap.get(user).remove(0);
                   			userPlayListMap.get(user).add(song);
            			 }
          			
          		}
        	 }else {
        		 userPlayListMap.put(user, new ArrayList<String>());
        		 userPlayListMap.get(user).add(song);
        	 }
     		System.out.println("Updated play list: "+userPlayListMap);
            
        }System.out.println("For Loop ended.");  
	}
	public static void main(String[] srgs) {
		//TestCase1 data
		String user = "user1";
		String[] song = {"s1","s2","s2","s4","s2"};
		System.out.println("Expected output: {user1=[s1, s4, s2]} and actual output: "+playListMethodStaticUser(user, song));

		//TestCase2 data
		String user1 = "";
		String[] song1 = {"s1","s2","s2","s4","s2"};
		System.out.println("Expected output: user and song is mandatory , and Actual output: "+playListMethodStaticUser(user1, song1));
		
		//TestCase3 data
		String user2 = "user3";
		String[] song2 = {};
		System.out.println("Expected output: user and song is mandatory , and Actual output: "+playListMethodStaticUser(user2, song2));
		
		//TestCase3 data
		String user3 = "";
		String[] song3 = {};
		System.out.println("Expected output: user and song is mandatory , and Actual output: "+playListMethodStaticUser(user3, song3));
		
		//TestCase4 data
		String user4 = "user4";
		String[] song4 = {"s1","s2"};
		System.out.println("Expected output: {user4=[s1, s2]} and actual output: "+playListMethodStaticUser(user4, song4));
		
		/*The below method can be used to check if the in-memory story can 
		accommodate N songs per user, with a fixed initial capacity set as 3*/
		playListMethodDynamicUser();
		
		/* Below is the sample output of playListMethodDynamicUser(); method
		enter user 
		user1
		enter song 
		s1
		Updated play list: {user1=[s1]}
		enter user 
		user2
		enter song 
		s2
		Updated play list: {user1=[s1], user2=[s2]}
		enter user 
		user1
		enter song 
		s2
		Updated play list: {user1=[s1, s2], user2=[s2]}
		enter user 
		user2
		enter song 
		s3
		Updated play list: {user1=[s1, s2], user2=[s2, s3]}
		enter user 
		user2
		enter song 
		s4
		Updated play list: {user1=[s1, s2], user2=[s2, s3, s4]}
		enter user 
		user1
		enter song 
		s3
		Updated play list: {user1=[s1, s2, s3], user2=[s2, s3, s4]}*/
		
		
		
 
        
        
        
        
}
}
