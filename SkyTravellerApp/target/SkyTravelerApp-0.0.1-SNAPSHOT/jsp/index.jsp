<!DOCTYPE html>
<html lang="en">
<head>
<title>Local Adventurer</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

/* Style the body */
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

/* Header/logo Title */
.header {
  padding: 10px;
  text-align: center;
  background: #1abc9c;
  color: white;
}
#myvideo{
position:fixed;

}

/* Increase the font size of the heading */
.header h1 {
  font-size: 50px;
  color: black;
  font: bold;
}

/* Style the top navigation bar */
.navbar {
  overflow: hidden;
  background-color: #333;
}

/* Style the navigation bar links */
.navbar a {
  float: left;
  display: block;
  color: white;
  text-align: center;
  padding: 14px 20px;
  text-decoration: none;
}

/* Right-aligned link */
.navbar a.right {
  float: right;
}

/* Change color on hover */
.navbar a:hover {
  background-color: #ddd;
  color: black;
}

/* Column container */
.row {  
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
}

/* Create two unequal columns that sits next to each other */
/* Sidebar/left column */
.side {
  -ms-flex: 30%; /* IE10 */
  flex: 30%;
  background-color: #f1f1f1;
  padding: 20px;
}

/* Main column */
.main {   
  -ms-flex: 70%; /* IE10 */
  flex: 70%;
  background-color: white;
  padding: 20px;
}

/* Fake image, just for this example */
.fakeimg {
  background-color: #aaa;
  width: 100%;
  padding: 20px;
}

/* Footer */
.footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
}

/* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 700px) {
  .row {   
    flex-direction: column;
  }
}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
  .navbar a {
    float: none;
    width: 100%;
  }
}
</style>
</head>
<body>

<div class="header">

 
 <div class="content">

  <h1>SKY TRAVELER</h1>
  <p>Worrry less,Enjoy more!</p>
  <img src="images/tenor2.gif" alt="Personal Description" width="100%" length= "1000" height="300">
  </div>
</div>
<div class="navbar">
  <a href="./airportfinder">AIRPORT FINDER</a>
  
  <a href="travel_news.jsp">TRAVEL NEWS</a>
  <a href="travel_warning.jsp">TRAVEL WARNINGS</a>
  <a href="./signup" class="right">SING-UP</a>
   <a href="./login" class="right"><i class="fa fa-fw fa-user"></i>SIGN-IN</a>
</div>

<div class="row">
  <div class="side">
   
    <h3>TRAVEL BLOGS</h3>
    
   <a href="https://youtu.be/sh9DUWKi8GE">
     <img src="images/goa.jpg" alt="Personal Description" style="height:150px;"></a>
      <a href="https://youtu.be/1qbSBRGnp2g">
      <img src="images/thailand.jpg" alt="Personal Description" style="height:150px;"></a>
      <a href="https://youtu.be/PdVLk_dPmtc">
       <img src="images/australia.jpg" alt="Personal Description" style="height:150px;"></a>
       <a href="https://youtu.be/Nir9N8fq8pI">
    <img src="images/africa.jpg" alt="Personal Description" style="height:150px;"></a>
   
  <a href="https://youtu.be/lhsBhZgKguA">
     <img src="images/mexico.jpg" alt="Personal Description" style="height:150px;"></a>

  <h2> Important Links</h2>
  <a href="https://cibtvisas.com/visa-quick-check">Visa Check</a><br>
  <a href="https://www.worldweatheronline.com/">Weather</a><br>
  <a href="https://www.hotels.com/?locale=en_US&pos=HCOM_US&rffrid=sem.hcom.US.google.003.00.03.s.kwrd=c.354244927571.66082596681.1624534025.1t1.kwd-11212371.9016963..hotels.Cj0KCQiAz53vBRCpARIsAPPsz8Woz-NtFVsrhMLePPNpOVRK9VlxMZSkVz--U5kOhFe8jqumiQhHdhQaAq4QEALw_wcB.aw.ds&PSRC=G21&gclid=Cj0KCQiAz53vBRCpARIsAPPsz8Woz-NtFVsrhMLePPNpOVRK9VlxMZSkVz--U5kOhFe8jqumiQhHdhQaAq4QEALw_wcB&gclsrc=aw.ds">Hotels</a>
  
   
   <H3>Why Local Adventurer?</H3>
    <p>This is an all in one application which would be handy for a traveler or even for travelers with unexpected changes in the travel plans for instance maybe change of plans due to flight cancellations, etc.</p>
     <p> Flights, Airports, News and Travel Warnings through the desktop or mobile site is a delightfully customer friendly experience, and with just a few clicks you can complete your search.</p>
    <br>
   

  </div>
</div>


</body>
</html>
