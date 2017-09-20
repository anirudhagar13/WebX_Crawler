> Performs depth first search crawling for a specific term from a base link mentioned by the user.
> Crawler jumps from one page to other navigational links situated on the page. Depth of search is given by the user as input.
> The result also contains various other details of the search term such as the frequency and positions of the word on the webpage.

How to Run:

	- Establish an Internet Connection.
	- Open eclipse and import WebX folder as General/Existing Projects into workspace
	- If Jsoup files already not present on importing, put JSoup jar files into the project external library. Jsoup jar files are present in this repo. 
	- Compile and build start.java file to run UI.
	- On the User Interface enter no of pages to Crawl.
	- Write a base valid link and enter word to be searched.
	- Crawler displays web graph, green indicates links on which word found & red indicates links where not found.
	- Click on Green Button to get Crawling Details of that Link.