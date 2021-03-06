<%-- 
    Document   : options
    Created on : Jun 30, 2012, 8:13:16 PM
    Author     : channiewu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
        <link type="text/css" href="css/hot-sneaks/jquery-ui-1.8.21.custom.css" rel="stylesheet" />
        <link href="css/style.css" rel="stylesheet">

        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" language="javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/mustache.js"></script>

	<script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <title>Make My Day!</title>
    </head>
<!--<body  style="background-color:#6ab200; background-image: -ms-linear-gradient(top, #FFFFFF, #6ab200); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#FFFFFF), to(#6ab200)); background-image: -webkit-linear-gradient(top, #FFFFFF, #6ab200); background-image: -o-linear-gradient(top, #FFFFFF, #6ab200); background-image: linear-gradient(top, #ffffff, #6ab200); background-image: -moz-linear-gradient(top, #ffffff, #6ab200);"> -->
<body>
    
    <a href="index.jsp" >Try another!</a>
        <script>
            var json = {"plans": [
                {
                    "name" : "Plan1",
                    "events": [
                        {"startTime": "Sat Jul 07 09:30:00 PDT 2012", 
                         "cat": "Fitness",
                         "address":"344 Tully Road,San Jose",
                         "eventUrl":"http://www.meetup.com/AsianMeetups/events/64437182/",
                         "eventName":"Water Balloons!  (Saturday, 7/7/12, 930am - South SJ)",
                         "endTime":"Sat Jul 07 12:30:00 PDT 2012",
                         "photoUrl":"http://photos1.meetupstatic.com/photos/event/f/b/f/global_43996031.jpeg",
                         "RSVPNum":41,
                         "duration": "1 hour", 
                         "direction": "35.0mi"
                        },
                        {"startTime": "Sat Jul 07 09:30:00 PDT 2012", 
                         "cat": "Fitness",
                         "address":"344 Tully Road,San Jose",
                         "eventUrl":"http://www.meetup.com/AsianMeetups/events/64437182/",
                         "eventName":"Water Balloons!  (Saturday, 7/7/12, 930am - South SJ)",
                         "endTime":"Sat Jul 07 12:30:00 PDT 2012",
                         "photoUrl":"http://photos1.meetupstatic.com/photos/event/f/b/f/global_43996031.jpeg",
                         "RSVPNum":41,
                         "duration": "1 hour", 
                         "direction": "35.0mi"
                        },
                         {"startTime": "Sat Jul 07 09:30:00 PDT 2012", 
                         "cat": "Fitness",
                         "address":"344 Tully Road,San Jose",
                         "eventUrl":"http://www.meetup.com/AsianMeetups/events/64437182/",
                         "eventName":"Water Balloons!  (Saturday, 7/7/12, 930am - South SJ)",
                         "endTime":"Sat Jul 07 12:30:00 PDT 2012",
                         "photoUrl":"http://photos1.meetupstatic.com/photos/event/f/b/f/global_43996031.jpeg",
                         "RSVPNum":41,
                         "duration": "", 
                         "direction": ""
                        }
                    ]
                },
                {
                    "name" : "Plan2",
                    "events": [
                        {"startTime": "Sat Jul 07 09:30:00 PDT 2012", 
                         "cat": "Fitness",
                         "address":"344 Tully Road,San Jose",
                         "eventUrl":"http://www.meetup.com/AsianMeetups/events/64437182/",
                         "eventName":"Water Balloons!  (Saturday, 7/7/12, 930am - South SJ)",
                         "endTime":"Sat Jul 07 12:30:00 PDT 2012",
                         "photoUrl":"http://photos1.meetupstatic.com/photos/event/f/b/f/global_43996031.jpeg",
                         "RSVPNum":41,
                         "duration": "1 hour", 
                         "direction": "35.0mi"
                        },
                        {"startTime": "Sat Jul 07 09:30:00 PDT 2012", 
                         "cat": "Fitness",
                         "address":"344 Tully Road,San Jose",
                         "eventUrl":"http://www.meetup.com/AsianMeetups/events/64437182/",
                         "eventName":"Water Balloons!  (Saturday, 7/7/12, 930am - South SJ)",
                         "endTime":"Sat Jul 07 12:30:00 PDT 2012",
                         "photoUrl":"http://photos1.meetupstatic.com/photos/event/f/b/f/global_43996031.jpeg",
                         "RSVPNum":41,
                         "duration": "1 hour", 
                         "direction": "35.0mi"
                        },
                        {"startTime": "Sat Jul 07 09:30:00 PDT 2012", 
                         "cat": "Fitness",
                         "address":"344 Tully Road,San Jose",
                         "eventUrl":"http://www.meetup.com/AsianMeetups/events/64437182/",
                         "eventName":"Water Balloons!  (Saturday, 7/7/12, 930am - South SJ)",
                         "endTime":"Sat Jul 07 12:30:00 PDT 2012",
                         "photoUrl":"http://photos1.meetupstatic.com/photos/event/f/b/f/global_43996031.jpeg",
                         "RSVPNum":41,
                         "duration": "", 
                         "direction": ""
                        }
                    ]
                }
            ]};
            
            
 
             
        $(function() {
            //var output = Mustache.render($('#events-template').html(), json);
            //$('#rendered-output').html(output);

            $.getJSON('json/jsonSample.json').done( function(data) {
                var plans = [];
                var cleanedUpData = {plans: plans};
                for (var i in data.planlist) {
                    var plan = data.planlist[i];
                    var events = [];
                    var routes = [];
                    var cleanedUpPlan = {};
                    if (i == 0) {
                     cleanedUpPlan = {name: ("Plan 1 (From your preference)" ), events: events, routes: routes}  
                    }
                    if (i == 1) {
                      cleanedUpPlan = {name: ("Plan 2 (More eventful!)" ), events: events, routes: routes}  
                    }
                                        
                    plans.push(cleanedUpPlan);
                    for (var j in plan) {
                        var event = plan[j];
                        //var route = 
                        if (event[0] === "event") {
                            events.push(event[1]);    
                        }   
                        if (event[0] === "route") {
                            routes.push(event[1]);    
                        } 
                    }
                }
                console.log(data);
                console.log(cleanedUpData);
                var template = $('#events-template').html();
                var html = Mustache.to_html(template, cleanedUpData);
                
                $('#rendered-output').html(html);
            }).fail(function() {
                console.log('fail!');
                console.log(arguments);
            });
        });

        </script>
            <a href=#><img src="img/mmd_logo.jpg"></a>
            

        <script type="mustache-template" id="events-template">
            <p>We have planned the following sets of exciting events for you! :)</p>
            <ul class="thumbnails">

                {{#plans}}
                        
<!--                <li class="span4" style="background-color:#6ab200; background-image: -ms-linear-gradient(top, #6ab200, #ffffff); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#6ab200), to(#ffffff)); background-image: -webkit-linear-gradient(top, #6ab200, #ffffff); background-image: -o-linear-gradient(top, #6ab200, #ffffff); background-image: linear-gradient(top, #6ab200, #ffffff); background-image: -moz-linear-gradient(top, #6ab200, #ffffff);">-->
                <li class="span4" style="background-color:#449AC8; background-image: -ms-linear-gradient(top, #449AC8, #ffffff); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#449AC8), to(#ffffff)); background-image: -webkit-linear-gradient(top, #449AC8, #ffffff); background-image: -o-linear-gradient(top, #449AC8, #ffffff); background-image: linear-gradient(top, #449AC8, #ffffff); background-image: -moz-linear-gradient(top, #449AC8, #ffffff);">
<!--                <li class="span4" style="background-color:#A3CDE4;">-->


                    <legend style="font-family: ARIAL; color: #0C2170;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{name}}</legend> 
           <!--         <div class="thumbnail"> -->
                        
                         <ul class="thumbnails meetup-event">
                        {{#events}}
                            <li class="span3" >
                                <div class="thumbnail meetup-event" style="overflow: auto;">
                            <h3><a href={{eventUrl}} style="color: #0C2170">{{eventName}}</a></h3>
                            <h4 style="color: #8E2B38;">{{startTimeStr}} - {{endTimeStr}}</h4>
                            <img src={{photoUrl}} alt="" style="display: inline; max-height: 50px; float: left;">
                            <text style="display: inline; ">@{{address}}</text>
                            <br/>
                            <text>({{rsvpnum}} RSVP)</text><br>           
                            <img src="img/down_arrow.png" style="max-height: 50px; border-width: 0; display: inline;" />
                            <text>{{direction}} {{duration}}</text>
                                </div>
                            </li>
                            
                        {{/events}}
                         </ul>
                   <!-- </div> -->
               </li>

                {{/plans}}

           </ul>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/end.jpeg" style="max-height: 100px; display: inline"/>
            
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/end.jpeg" style="max-height: 100px; display: inline"/>
        </script>
        
        <div id="rendered-output">
            
        </div>

        
        
<!--        <% String url = "https://maps.google.com/maps?f=d&amp;source=s_d&amp;saddr=2029+Stierlin+Court,+Mountain+View,+CA&amp;daddr=Facebook+Inc,+Willow+Road,+Menlo+Park,+CA&amp;hl=en&amp;geocode=FZsIOwIdKFm5-CkL33pp47mPgDF0a3Fa-Wj2tA%3BFfXyOwIdayO4-CH4NlJhSitLNCmVRiKC6rqPgDH4NlJhSitLNA&amp;aq=2&amp;oq=face&amp;sll=37.43199,-122.112275&amp;sspn=0.076062,0.154324&amp;mra=ls&amp;ie=UTF8&amp;t=m&amp;ll=37.431932,-122.11235&amp;spn=0.040894,0.051498&amp;z=13&amp;output=embed";
        %>
        <div style="margin-left: auto; margin-right: auto;">
        <iframe width="300" height="300" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src=<%=url%>></iframe><br /><small><a href="https://maps.google.com/maps?f=d&amp;source=embed&amp;saddr=2029+Stierlin+Court,+Mountain+View,+CA&amp;daddr=Facebook+Inc,+Willow+Road,+Menlo+Park,+CA&amp;hl=en&amp;geocode=FZsIOwIdKFm5-CkL33pp47mPgDF0a3Fa-Wj2tA%3BFfXyOwIdayO4-CH4NlJhSitLNCmVRiKC6rqPgDH4NlJhSitLNA&amp;aq=2&amp;oq=face&amp;sll=37.43199,-122.112275&amp;sspn=0.076062,0.154324&amp;mra=ls&amp;ie=UTF8&amp;t=m&amp;ll=37.431932,-122.11235&amp;spn=0.040894,0.051498&amp;z=13" style="color:#0000FF;text-align:left">View Larger Map</a></small>
        </div>-->
    </body>
</html>