/*
 * @author Fan Chen
 * created on Jan 17, 2012
 * /

/* 
 * returns a new XMLHttpRequest object, or false if the browser doesn't support it
 */

function newXMLHttpRequest(){
    var xmlreq = false;
    
    // in non-microsoft browsers
    if(window.XMLHttpRequest){
        xmlreq = new XMLHttpRequest();
    }else if(window.ActiveXObject){
        try{
            //in later versions of IE
            xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
        }catch(e1){
            try{
                //in older vversions of IE
                xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
            }catch(e2){
                xmlreq=false;
            }
        }
    }
    return xmlreq;
}
/*
 * returns a function that waits for the specified XMLHttpRequest to complete
 * then passes it the XML response to the given handler function
 * 
 * req: the XMLHttpRequest whose state is changing
 * responseXmlHandler: Function to pass the XML response to
 */
 function getReadyStateHandler(req, responseXmlHandler) {
     return function () {
         if (req.readyState == 4) {
             if (req.status == 200) {
                 responseXmlHandler(req.responseText);
         } else {
             alert("HTTP error "+req.status+": "+req.statusText);
       }
     }
   }
 }
