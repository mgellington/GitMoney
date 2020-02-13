<html>

	<head>
		<!-- Web page title -->
    	<title>Top Trumps - Game</title>
    	
    	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    	<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
    	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">

		<!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
		<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/TREC_IS/bootstrap.min.css">
    	<script src="http://dcs.gla.ac.uk/~richardm/vex.combined.min.js"></script>
    	<script>vex.defaultOptions.className = 'vex-theme-os';</script>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex.css"/>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex-theme-os.css"/>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

	</head>

    <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
    	
    	<div class="container">
        <!-- Stylising the cards with css-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
					<style>
					.card {
					box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
					transition: 0.3s;
					width: 40%;
					border-radius: 5px;
					}

					.card:hover {
					box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
					}

					img {
					border-radius: 5px 5px 0 0;
					}

					.container {
					padding: 2px 16px;
					}
					</style>
							<!-- importing bootstrap stylesheet -->
							<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
						<title>
							Glasgow Bars Top Trumps
						</title>
						<!-- required meta tags -->
						<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
							<!-- creates rectangles to represent cards - not sure if this is the correct way to do this -->
					<style>
						
					.rectangle {
					height: 200px;
					width: 150px;
					background-color: rgb(235, 179, 179);
					}
					</style>
						</head>

						<body>
							<div class="container-fluid">
								<div class ="row">
									<div class ="col">
										<h1 class="blockquote text-center">
											Glasgow Bars Top Trumps
										</h1>
									</div>
								</div>
							</div>

							<div class="container">
								<div class="row">
								<div class="col-sm">
									Information
									<div class="rectangle">
										<div>
											<p>
											Round Number: <br>
											Active Player: <br>
											Category Chosen: <br>
										

											</p>
											</div>
									</div>
									<button onclick="MyFunction()" type="button" class="btn btn-success">Next</button>
									</div> 

                <!-- human player card -->
              <div class="col-sm">
                Human Player <span class="badge badge-pill badge-dark">XX</span>
                <div class="card", style="width:80%" style="height:100%;">
                    <div class ="container">
                        <div class ="card-header">Card Name </div>
                            <p>
                                Stat1<br>
                                Stat2<br>
                                Stat3<br>
                                Stat4<br>
                                Stat5<br>
                            </p>
                        </div>
                      
    
                    </div>
              </div>

              <div class="col-sm">
                AI Player 1 <span class="badge badge-pill badge-dark">XX</span>
                <div class="card", style="width:80%" style="height:100%;">
                    <div class ="container">
                        <div class ="card-header">Card Name </div>
                            <p>
                                Stat1<br>
                                Stat2<br>
                                Stat3<br>
                                Stat4<br>
                                Stat5<br>
                            </p>
                        </div>
                      
    
                    </div>
              </div>

              <div class="col-sm">
                  AI Player 2 <span class="badge badge-pill badge-dark">XX</span>
                  <div class="card", style="width:80%" style="height:100%;">
                    <div class ="container">
                        <div class ="card-header">Card Name </div>
                            <p>
                                Stat1<br>
                                Stat2<br>
                                Stat3<br>
                                Stat4<br>
                                Stat5<br>
                            </p>
                        </div>
                      
    
                    </div>
              </div>
            </div>
        </div>

        <div class = "container">
            <div class="row">

                <div class="col-sm">
                  <!-- next button, and select category drop down menu-->
                  <div class="dropdown show">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Choose a category
                    </a>
                 <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" onclick="PintPriceFunction()" href="#">Pint Price</a>
                    <a class="dropdown-item" onclick="AtmosphereFunction()" href="#">Atmosphere</a>
                    <a class="dropdown-item" onclick="PubQuizFunction()" href="#">Pub Quiz Quality</a>
                    <a class="dropdown-item" onclick="MusicQualityFunction()" href="#">Music Quality</a>
                    <a class="dropdown-item" onclick="StickyFunction()" href="#">Floor Stickiness</a>
                  </div>
                </div>
                  </div>
               
                <div class="col-sm">
                  AI Player 3 <span class="badge badge-pill badge-dark">XX</span>
                  <div class="card", style="width:80%" style="height:100%;">
                    <div class ="container">
                        <div class ="card-header">Card Name </div>
                            <p>
                                Stat1<br>
                                Stat2<br>
                                Stat3<br>
                                Stat4<br>
                                Stat5<br>
                            </p>
                        </div>
                      
    
                    </div>
                </div>

                <div class="col-sm">
                  AI Player 4 <span class="badge badge-pill badge-dark">XX</span>
                  <div class="card", style="width:80%" style="height:100%;">
                    <div class ="container">
                        <div class ="card-header">Card Name </div>
                            <p>
                                Stat1<br>
                                Stat2<br>
                                Stat3<br>
                                Stat4<br>
                                Stat5<br>
                            </p>
                        </div>
                      
    
                    </div>
                </div>

                <div class="col-sm">
                    AI Player 5 <span class="badge badge-pill badge-dark">15</span>
                <!-- Julia's attempt to card-->
                <div class="card", style="width:80%" style="height:100%;">
                <div class ="container">
                    <div class ="card-header">Card Name </div>
                        <p>
                            Stat1<br>
                            Stat2<br>
                            Stat3<br>
                            Stat4<br>
                            Stat5<br>
                        </p>
                    </div>
                  

                </div>

                
            </div>
        

          <script type = "text/javascript">
            function MyFunction(){
                var url = "https://www.guu.co.uk/";
                window.location.replace(url);
            }
          </script>
        
        <!-- JavaScript if function from google
           if (condition) {   }
            //  block of code to be executed if the condition is true -->

        <script type = "text/javascript">
            function PintPriceFunction(){
            var url = "https://www.reddit.com/";
            window.location.replace(url);
         }
         </script>
         <script type = "text/javascript">
          function AtmosphereFunction(){
             var url = "https://www.reddit.com/";
             window.location.replace(url);
          }
          </script>
          <script type = "text/javascript">
            function PubQuizFunction(){
               var url = "https://www.reddit.com/";
               window.location.replace(url);
            }
            </script>
            <script type = "text/javascript">
              function MusicQualityFunction(){
                 var url = "https://www.reddit.com/";
                 window.location.replace(url);
              }
              </script>
              <script type = "text/javascript">
                function StickyFunction(){
                   var url = "https://www.reddit.com/";
                   window.location.replace(url);
                }
                </script>
        
          <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>  

			</body>
		</div>

</html>	
		
		<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
			
				// --------------------------------------------------------------------------
				// You can call other methods you want to run when the page first loads here
				// --------------------------------------------------------------------------
				
				// For example, lets call our sample methods
				helloJSONList();
				helloWord("Student");
				
			}
			
			// -----------------------------------------
			// Add your other Javascript methods Here
			// -----------------------------------------
		
			// This is a reusable method for creating a CORS request. Do not edit this.
			function createCORSRequest(method, url) {
  				var xhr = new XMLHttpRequest();
  				if ("withCredentials" in xhr) {

    				// Check if the XMLHttpRequest object has a "withCredentials" property.
    				// "withCredentials" only exists on XMLHTTPRequest2 objects.
    				xhr.open(method, url, true);

  				} else if (typeof XDomainRequest != "undefined") {

    				// Otherwise, check if XDomainRequest.
    				// XDomainRequest only exists in IE, and is IE's way of making CORS requests.
    				xhr = new XDomainRequest();
    				xhr.open(method, url);

 				 } else {

    				// Otherwise, CORS is not supported by the browser.
    				xhr = null;

  				 }
  				 return xhr;
			}
		
		</script>
		
		<!-- Here are examples of how to call REST API Methods -->
		<script type="text/javascript">
		
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloJSONList() {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloJSONList"); // Request type and URL
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}

				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}
			
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloWord(word) {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloWord?Word="+word); // Request type and URL+parameters
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}

				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}

		</script>
		
		</body>
</html>