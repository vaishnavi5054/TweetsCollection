import java.io.BufferedWriter;
	import java.io.BufferedReader;
	import java.io.DataOutputStream;
	import java.io.InputStreamReader;
	import java.io.StringReader;
	import java.net.HttpURLConnection;
	import java.net.URL;
	 

	import javax.net.ssl.HttpsURLConnection;
	import javax.swing.text.Document;
	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;

	import java.io.File;
	import java.io.FileWriter;
	import java.util.*;

	import org.json.simple.JSONObject;
	import org.w3c.dom.Node;
	import org.w3c.dom.NodeList;
	import org.xml.sax.InputSource;
	import org.w3c.dom.Element;

	import twitter4j.*;
	import twitter4j.auth.AccessToken;
	import twitter4j.auth.OAuthSupport;
	import twitter4j.conf.ConfigurationBuilder;

	public class Tweetscollection  {
	   
	    public static String getcountry(String location)
	    {
	       
	        List <String> list = new ArrayList(); 
	        list.add("ALABAMA");
	        list.add("ALASKA");
	        list.add("ARIZONA");
	        list.add("ARKANSAS");
	        list.add("CALIFORNIA");
	        list.add("COLORADO");
	        list.add("CONNECTICUT");
	        list.add("DELAWARE");
	        list.add("DISTRICT OF COLUMBIA");
	        list.add("FLORIDA");
	        list.add("GEORGIA");
	        list.add("HAWAII");
	        list.add("IDAHO");
	        list.add("ILLINOIS");
	        list.add("INDIANA");
	        list.add("IOWA");
	        list.add("KANSAS");
	        list.add("KENTUCKY");
	        list.add("LOUISIANA");
	        list.add("MAINE");
	        list.add("MARYLAND");
	        list.add("MASSACHUSETTS");
	        list.add("MICHIGAN");
	        list.add("MINNESOTA");
	        list.add("MISSISSIPPI");
	        list.add("MISSOURI");
	        list.add("MONTANA");
	        list.add("NEBRASKA");
	        list.add("NEVADA");
	        list.add("NEW HAMPSHIRE");
	        list.add("NEW JERSEY");
	        list.add("NEW YORK");
	        list.add("CAROLINA");
	        list.add("DAKOTA");
	        list.add("MARIANA ");
	        list.add("OHIO");
	        list.add("OKLAHOMA");
	        list.add("OREGON");
	        list.add("PALAU");
	        list.add("PENNSYLVANIA");
	        list.add("TENNESSEE");
	        list.add("TEXAS");
	        list.add("UTAH");
	        list.add("VERMONT");
	        list.add("VIRGIN");
	        list.add("WASHINGTON");
	        list.add("WISCONSIN");
	        list.add("WYOMING");
	     
	       

	        List <String> listCountry = new ArrayList<String>();
	        for (String i : list){
	              if (location.toUpperCase().contains(i)){
	                return "USA";
	               
	              }
	            }
	   
	        return null;
	    }
	     public static void main(String[] args) {
	         
	    	 			query();         
	         
	                    ConfigurationBuilder cb = new ConfigurationBuilder();
	                    cb.setOAuthConsumerKey("fRvVhoeP0ILsWavD6yzdvqfFA");
	                    cb.setOAuthConsumerSecret("7Wxa1OCteCfJxqqr9ID93fkawe2WvLY06yrCx35soeOVubkEsk");
	                    cb.setOAuthAccessToken("455697025-muSl8329n4w3MpyZ90DDyYRPTafbsYas2NARxIYx");
	                    cb.setOAuthAccessTokenSecret("gKVmrdK7mlJFduvfIvsWXMQm2oZ1gVL3HCBhj9pBsmgoN")  ;   
	           TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
	            //final TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
	            
	              
	            final StatusListener streamListener = new StatusListener() {
	//This method is used to handle an exception
	                @Override
	                public void onException(Exception e) {
	                            System.out.println(e);
	                }
	               
	//This method gives the deletion notice if any of the status is deleted from the twitter account
	                @Override
	                public void onDeletionNotice(StatusDeletionNotice arg0) {
	                    // TODO Auto-generated method stub

	            }
	//This method gives the notice to the clients to remove geographical location information
	                //@Override
	                public void onScrubGeo(long arg0, long arg1) {
	                    // TODO Auto-generated method stub

	                }
	//This method is used to send notice to the client if limited stream becomes unlimited               
	                @Override
	                public void onTrackLimitationNotice(int arg0) {
	                    // TODO Auto-generated method stub
	                }
	            
	                @Override
	                public void onStatus(Status status) {
	                    User userLocation = status.getUser();
	                   
	                    // username holds the user's name
	                    String userName = status.getUser().getScreenName();
	                   //profileLocation holds the location from where the user tweets
	                    String profileLocation = userLocation.getLocation();
	                  //tweetId is a unique id for every tweet
	                    long tweetId = status.getId();
	                   //tweetContent holds the content of tweets
	                    String tweetContent = status.getText(); 
	                  // int favcount= status.getFavoriteCount();--R
	                   int retweetcount = (int) status.getRetweetCount();
	                   
	                  Date date= status.getCreatedAt();
	                 
	                    JSONObject jsonObject = new JSONObject(); 
	                    jsonObject.put(" UserName ", userName); 
	                    jsonObject.put(" UserLocation ", profileLocation);
	                    String country=getcountry(profileLocation);
	                    jsonObject.put(" TweetId ", tweetId); 
	                    jsonObject.put(" TweetContent ", tweetContent); 
	                    jsonObject.put("Country", country);
	                   //jsonObject.put("FavouriteCount", favcount);
	                    jsonObject.put("RetweetCount", retweetcount);
	                    jsonObject.put("Date", date);
	                  
//	                   

	                }
	                
	                public  void onStallWarning(StallWarning sw) {
	                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	                }


	            };
	            FilterQuery fq = new FilterQuery();
	           
	              String keywords[] = {"justin beiber"};
	              fq.track(keywords);

	        twitterStream.addListener(streamListener);
	        twitterStream.filter(fq); 

	        }
	     
	      public static void query()
	         {
	            
	             try
	                {
	                 System.out.println("1");
	                    ConfigurationBuilder cb = new ConfigurationBuilder();
	         cb.setOAuthConsumerKey("rSnfEuPxIV2i3zBKJS3QTMa8m");
	         cb.setOAuthConsumerSecret("NEygU4y3Bivw8IYL305OpnsY7O7ilXlPrFHP63ha3KklUAXgdY");
	         cb.setOAuthAccessToken("455697025-muSl8329n4w3MpyZ90DDyYRPTafbsYas2NARxIYx");
	         cb.setOAuthAccessTokenSecret("gKVmrdK7mlJFduvfIvsWXMQm2oZ1gVL3HCBhj9pBsmgoN");     
	                Twitter twitter =new TwitterFactory(cb.build()).getInstance();
	               Query query= new Query("justin beiber");
	               System.out.println("1");
	           int numberOfTweets = 999999;
	            long lastID = Long.MAX_VALUE;
	            List<Status> tweets = new ArrayList<>();
	            while (tweets.size () < numberOfTweets) {//1000<99999
	              if (numberOfTweets - tweets.size() > 100)
	              {
	                query.setCount(100);
	             
	              }
	              else
	                query.setCount(numberOfTweets - tweets.size());
	            //  System.out.println("1.1");
	              try {
	              
	                  // System.out.println("4");
	                  QueryResult result = twitter.search(query);
	                // System.out.println("4.1");
	                  tweets.addAll((Collection<? extends Status>) result.getTweets());
	              
	                  System.out.println("Gathered " + tweets.size() + " tweets");
	                  int i=0;
	                for (Status t: tweets)
	                {
	                    if(t.getGeoLocation()!= null)
	                    {
	                      
	                  
	                     User userLocation = t.getUser();
	                      
	                        // username holds the user's name
	                        String userName = t.getUser().getScreenName();
	                       //profileLocation holds the location from where the user tweets
	                        String profileLocation = userLocation.getLocation();
	                      //tweetId is a unique id for every tweet
	                        long tweetId = t.getId();
	                       //tweetContent holds the content of tweets
	                        String tweetContent = t.getText();
	                       //int favcount= t.getFavoriteCount();
	                       int retweetcount =(int) t.getRetweetCount();
	                      double latitide=t.getGeoLocation().getLatitude();
	                      double longitude = t.getGeoLocation().getLongitude();
	                       Date date= t.getCreatedAt();

	                       ///////////////////////////////
	                
	                       String url = "http://api.geonames.org/countrySubdivision?lat="+latitide+"&lng="+longitude+"&username=vaishnavi899";
	                        final String USER_AGENT = "Chrome/51.0.2704.106";
	                       URL obj = new URL(url);
	                       HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	               
	                       // optional default is GET
	                       con.setRequestMethod("GET");
	               
	                       //add request header
	                       con.setRequestProperty("User-Agent", USER_AGENT);
	               
	                       int responseCode = con.getResponseCode();
	                          
	                       BufferedReader in = new BufferedReader(
	                               new InputStreamReader(con.getInputStream()));
	                       String inputLine;
	                       StringBuffer response = new StringBuffer();
	               
	                       while ((inputLine = in.readLine()) != null) {
	                           response.append(inputLine);
	                       }
	                       in.close();
	                      
	                             
	                       //print result
	                       System.out.println(response.toString());
	                      
	                       String xmlString = response.toString(); 

	                       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
	                       DocumentBuilder builder; 
	                        
	                           builder = factory.newDocumentBuilder(); 
	                         org.w3c.dom.Document document = builder.parse( new InputSource( new StringReader( xmlString ) ) );           
	                     
	              
	                   NodeList nList = document.getElementsByTagName("countrySubdivision");
	                       Node cnode = nList.item(0);
	                       Element element = (Element) cnode;
	                   // System.out.println("2.2");
	               String country1=    element.getElementsByTagName("countryName").item(0).getTextContent();
	                    System.out.println("3");
	                       System.out.println("Country is :" + country1);
	                       ////////////////////////////
	                      
	                         JSONObject jsonObject = new JSONObject();
	                        jsonObject.put(" UserName ", userName);
	                        jsonObject.put(" UserLocation ", profileLocation);
	                        String country=getcountry(profileLocation);
	                        jsonObject.put(" TweetId ", tweetId);
	                        jsonObject.put(" TweetContent ", tweetContent);
	                        jsonObject.put("Country", country1);
	                        //jsonObject.put("FavouriteCount", favcount);
	                        jsonObject.put("RetweetCount", retweetcount);
	                        jsonObject.put("Date", date);
	                       jsonObject.put("Latitude", latitide);
	                       jsonObject.put("Longitude", longitude);
	                        try
	                        {
	                             File file=new File("/home/biadmin/Desktop/NewJSONFile12.json");
	                             BufferedWriter bf = null;
	                             //If file doesnot exist create a new file
	                            if(!file.exists())
	                            {
	                             file.createNewFile();
	                            
	                            }
	                            //if file exists the append the content
	                            final FileWriter fileWriter = new FileWriter(file,true);
	                            bf = new BufferedWriter(fileWriter);
	                            bf.append(jsonObject.toJSONString());
	                            bf.newLine();
	                            System.out.println(jsonObject.toJSONString());                                     
	                             bf.close();
	                             fileWriter.close();  
	                          
	                          
	                        }
	                        catch (Exception e)
	                        {
	                            System.out.println(e);
	                        }
	                       
	                       finally
	                       {
	                           //fileWriter.close();
	                       }
	                    i++;
	                    System.out.println(i+":"+t.getUser().getScreenName()+":"+t.getCreatedAt()+":"+t.getText());
	                    // System.out.println("6");
	                    }
	                  if(t.getId() < lastID)
	                      {
	                      lastID = t.getId();
	                
	                  }
	                }

	              }

	              catch (TwitterException te) {
	                System.out.println("Couldn't connect: " + te);
	              };
	              query.setMaxId(lastID-1);
	          
	            }
	                }
	                catch(Exception e)
	                {
	                  
	                }
	         }

	    }
