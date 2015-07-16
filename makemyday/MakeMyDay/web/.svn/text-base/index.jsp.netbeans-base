<%-- 
    Document   : index
    Created on : Jun 30, 2012, 11:37:09 AM
    Author     : fchen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

        <script type="text/javascript" language="javascript" src="javascript.js"></script>
        <script type="text/javascript" language="javascript" src="bootstrap.js"></script>
        <script type="text/javascript" language="javascript" src="bootstrap.min.js"></script>
		<link type="text/css" href="css/hot-sneaks/jquery-ui-1.8.21.custom.css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
		<script type="text/javascript">
			$(function(){

				// Accordion
				$("#accordion").accordion({ header: "h3" });

				// Tabs
				$('#tabs').tabs();

				// Dialog
				$('#dialog').dialog({
					autoOpen: false,
					width: 600,
					buttons: {
						"Ok": function() {
							$(this).dialog("close");
						},
						"Cancel": function() {
							$(this).dialog("close");
						}
					}
				});

				// Dialog Link
				$('#dialog_link').click(function(){
					$('#dialog').dialog('open');
					return false;
				});

				// Datepicker
				$('#datepicker').datepicker({
					inline: true, minDate: +1
				}).val();

				// Slider
				$('#slider').slider({
					range: "max",
                                        min: 1,
                                        max: 100,
                                        value: 25,
                                        slide: function( event, ui ) {
				$( "#radius" ).val( ui.value );
			}
				});
                                $( "#radius" ).val( $( "#slider" ).slider( "value" ) );
                                $( "#date" ).val( $( "#datepicker" ).datepicker("getDate") );

				// Progressbar
				$("#progressbar").progressbar({
					value: 20
				});

				//hover states on the static widgets
				$('#dialog_link, ul#icons li').hover(
					function() { $(this).addClass('ui-state-hover'); },
					function() { $(this).removeClass('ui-state-hover'); }
				);
                                $( "input:submit").button();

			});
		</script>
        <title>Make my Day!</title>

    </head>
 <!-- <body style="background-color:#6ab200; background-image: -ms-linear-gradient(top, #FFFFFF, #6ab200); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#FFFFFF), to(#6ab200)); background-image: -webkit-linear-gradient(top, #FFFFFF, #6ab200); background-image: -o-linear-gradient(top, #FFFFFF, #6ab200); background-image: linear-gradient(top, #ffffff, #6ab200); background-image: -moz-linear-gradient(top, #ffffff, #6ab200);"> -->
<!--<body style="background-image: url('img/mmd_bg.jpeg')"> -->
<body>
        <a href=#><img src="img/mmd_logo.jpg"></a> <br><br><br>
        
        <form action="MMDServlet" method="get">
            <ul class="thumbnails">
                <li class="span6">
<!--                    <div class="thumbnail" style="min-height: 225px; background-color: #6ab200; background-image: -ms-linear-gradient(top, #6ab200, #ffffff); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#6ab200), to(#ffffff)); background-image: -webkit-linear-gradient(top, #6ab200, #ffffff); background-image: -o-linear-gradient(top, #6ab200, #ffffff); background-image: linear-gradient(top, #6ab200, #ffffff); background-image: -moz-linear-gradient(top, #6ab200, #ffffff); ">-->
                    <div class="thumbnail" style="min-height: 225px; background-color: #449AC8; background-image: -ms-linear-gradient(top, #449AC8, #ffffff); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#449AC8), to(#ffffff)); background-image: -webkit-linear-gradient(top, #449AC8, #ffffff); background-image: -o-linear-gradient(top, #449AC8, #ffffff); background-image: linear-gradient(top, #449AC8, #ffffff); background-image: -moz-linear-gradient(top, #449AC8, #ffffff); ">


                        <legend style="font-family: ARIAL; color: #0C2170;">Where?</legend>
                        
                        Zip Code: <input type="text" name="zip" id="zip"/><br>
                        Miles: (On a scale of 1 to 100) <br> <br>
                         <input type="text" name="radius"id="radius" style="border:0; opacity: 0.5" /><br>
                        <div id="slider"></div>
                       
                    </div>
                </li> 
                <li class="span6">
<!--                    <div class="thumbnail" style="min-height: 225px; background-color: #6ab200; background-image: -ms-linear-gradient(top, #6ab200, #ffffff); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#6ab200), to(#ffffff)); background-image: -webkit-linear-gradient(top, #6ab200, #ffffff); background-image: -o-linear-gradient(top, #6ab200, #ffffff); background-image: linear-gradient(top, #6ab200, #ffffff); background-image: -moz-linear-gradient(top, #6ab200, #ffffff); ">-->
                    <div class="thumbnail" style="min-height: 225px; background-color: #449AC8; background-image: -ms-linear-gradient(top, #449AC8, #ffffff); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#449AC8), to(#ffffff)); background-image: -webkit-linear-gradient(top, #449AC8, #ffffff); background-image: -o-linear-gradient(top, #449AC8, #ffffff); background-image: linear-gradient(top, #449AC8, #ffffff); background-image: -moz-linear-gradient(top, #449AC8, #ffffff); ">

                        <legend style="font-family: ARIAL; color: #0C2170;">When?</legend>
                        <div class="alert alert-info">The earliest you can plan for is from tomorrow! :)</div>
                        <input type="date" name="date" id="date"/>
  
                    </div>
                </li>
                <li class="span12">
<!--                    <div class="thumbnail" style="min-height: 225px; background-color:#6ab200; background-image: -ms-linear-gradient(top, #6ab200, #ffffff); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#6ab200), to(#ffffff)); background-image: -webkit-linear-gradient(top, #6ab200, #ffffff); background-image: -o-linear-gradient(top, #6ab200, #ffffff); background-image: linear-gradient(top, #6ab200, #ffffff); background-image: -moz-linear-gradient(top, #6ab200, #ffffff);">-->
                    <div class="thumbnail" style="min-height: 225px; background-color: #449AC8; background-image: -ms-linear-gradient(top, #449AC8, #ffffff); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#449AC8), to(#ffffff)); background-image: -webkit-linear-gradient(top, #449AC8, #ffffff); background-image: -o-linear-gradient(top, #449AC8, #ffffff); background-image: linear-gradient(top, #449AC8, #ffffff); background-image: -moz-linear-gradient(top, #449AC8, #ffffff); ">

                        <legend style="font-family: ARIAL; color: #0C2170;">What?</legend>
                        <div class="alert alert-info">You can select only upto three activities! Lets not be too ambitious here! :)</div>
                        


              <select name="choice_1"id="choice_1">
                <option value="">Select your first choice!</option>
                <option value="Career">Career</option>
                <option value="Camping">Camping</option>
                <option value="Business">Business</option>
                <option value="Education">Education</option>
                <option value="Entrepreneurship">Entrepreneurship</option>
                <option value="Beauty">Beauty</option>
                <option value="Fitness">Fitness</option>
                <option value="Dance">Dance</option>
                <option value="Diningout">Diningout</option>
                <option value="Games">Games</option>
                <option value="Health and Wellness">Health and Wellness</option>
                <option value="Hiking">Hiking</option>
                <option value="Lifestyle">Lifestyle</option>
                <option value="Politics">Politics</option>
                <option value="Movies">Movies</option>
                <option value="Music">Music</option>
                <option value="Meditation">Meditation</option>
                <option value="Spirituality">Spirituality</option>
                <option value="Adventurers">Adventurers</option>
                <option value="Photography">Photography</option>
                <option value="Rock Climbing">Rock Climbing</option>
                <option value="Singles">Singles</option>
                <option value="Social Networking">Social Networking</option>
                <option value="Sports">Sports</option>
                <option value="Software Developers">Software Developers</option>
                <option value="Salsa">Salsa</option>
                <option value="Support">Support</option>
                <option value="Tech">Tech</option>
                <option value="Travel">Travel</option>
                <option value="Women">Women</option>
              </select>
              <select name="choice_2"id="choice_2">
                <option value="">Select your first choice!</option>
                <option value="Career">Career</option>
                <option value="Camping">Camping</option>
                <option value="Business">Business</option>
                <option value="Education">Education</option>
                <option value="Entrepreneurship">Entrepreneurship</option>
                <option value="Beauty">Beauty</option>
                <option value="Fitness">Fitness</option>
                <option value="Dance">Dance</option>
                <option value="Diningout">Diningout</option>
                <option value="Games">Games</option>
                <option value="Health and Wellness">Health and Wellness</option>
                <option value="Hiking">Hiking</option>
                <option value="Lifestyle">Lifestyle</option>
                <option value="Politics">Politics</option>
                <option value="Movies">Movies</option>
                <option value="Music">Music</option>
                <option value="Meditation">Meditation</option>
                <option value="Spirituality">Spirituality</option>
                <option value="Adventurers">Adventurers</option>
                <option value="Photography">Photography</option>
                <option value="Rock Climbing">Rock Climbing</option>
                <option value="Singles">Singles</option>
                <option value="Social Networking">Social Networking</option>
                <option value="Sports">Sports</option>
                <option value="Software Developers">Software Developers</option>
                <option value="Salsa">Salsa</option>
                <option value="Support">Support</option>
                <option value="Tech">Tech</option>
                <option value="Travel">Travel</option>
                <option value="Women">Women</option>
              </select>
              <select name="choice_3"id="choice_3">
                <option value="">Select your first choice!</option>
                <option value="Career">Career</option>
                <option value="Camping">Camping</option>
                <option value="Business">Business</option>
                <option value="Education">Education</option>
                <option value="Entrepreneurship">Entrepreneurship</option>
                <option value="Beauty">Beauty</option>
                <option value="Fitness">Fitness</option>
                <option value="Dance">Dance</option>
                <option value="Diningout">Diningout</option>
                <option value="Games">Games</option>
                <option value="Health and Wellness">Health and Wellness</option>
                <option value="Hiking">Hiking</option>
                <option value="Lifestyle">Lifestyle</option>
                <option value="Politics">Politics</option>
                <option value="Movies">Movies</option>
                <option value="Music">Music</option>
                <option value="Meditation">Meditation</option>
                <option value="Spirituality">Spirituality</option>
                <option value="Adventurers">Adventurers</option>
                <option value="Photography">Photography</option>
                <option value="Rock Climbing">Rock Climbing</option>
                <option value="Singles">Singles</option>
                <option value="Social Networking">Social Networking</option>
                <option value="Sports">Sports</option>
                <option value="Software Developers">Software Developers</option>
                <option value="Salsa">Salsa</option>
                <option value="Support">Support</option>
                <option value="Tech">Tech</option>
                <option value="Travel">Travel</option>
                <option value="Women">Women</option>
              </select>
                 </div>
                </li>
            </ul>

             
                        
        
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="Lets Go!"/>
        </form>
    </body>
</html>
