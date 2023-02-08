package com.userManagmentSystem.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;



@Service
public class UserService {

	 private static List<User> user=new ArrayList<>(); // In-memory database
	    private static int userCount=0;

	    static {
	    	user.add(new User(++userCount,"Pratham","PrathamWate","Paratwada","884776993"));
	    	user.add(new User(++userCount,"Parth","ParthWate","Paratwada","8378011836"));
	    	user.add(new User(++userCount,"Rohit","RohitSharma","Mumbai","4451560442"));
	    	user.add(new User(++userCount,"Matin","MatinShah","Achalpur","8847774193"));
	    	user.add(new User(++userCount,"rohit","RohitMandale","Achalpur","8847764777"));
	    }

		public List<User> allUser() {
			
			return user;
		}

		public User getUser(int userId) {
//			 Predicate<? super User> predicate = todo -> todo.getUserId() == userId;
//			 User u= user.stream().filter(predicate).findFirst().get();
//		     return u;
			
				for(int i=0;i<user.size();i++) {
					User u=user.get(i);
					if(userId==u.getUserId()) {
						return u;
					}
				}
				return null;
			}

		public void addUser(User user2) {
		   user.add(user2);
			
		}

		public void deleteUser(int userId) {
			for(int i=0;i<user.size();i++) {
				User u=user.get(i);
				if(userId==u.getUserId()) {
					user.remove(u);
				}
			}
//               Predicate<? super User> predicate = user -> user.getUserId() == userId;
//		        user.removeIf(predicate);
		}

		public void updateUserInfo(int userId, User user2) {
			User u=getUser(userId);
			
			u.setName(user2.getName());
			u.setUserName(user2.getUserName());
			u.setNumber(user2.getNumber());
			u.setAddrees(user2.getAddrees());
			
		}
	
}
