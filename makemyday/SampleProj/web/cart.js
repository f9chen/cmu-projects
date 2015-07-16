/* 
 * @author Fan Chen
 * 
 * created on Jan 17, 2012
 */

//last updated timestamp
var lastCartUpdate = 0;

/*
 * add item to cart via AJAX
 * itemCode - product code of the item to add
 */
function addToCart(itemCode){
    var request = newXMLHttpRequest();
    request.onreadystatechange = getReadyStateHandler(request, updateCart);
    
    request.open("POST","CartServlet",true);
    request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    request.send("action=add&item="+itemCode);
}

/*
 * update the cart content in Json
 */

function updateCart(cartJson){
   // it seems that CartJson didn't come in here! 
   
   //alert(cartJson);
    
    //for debug
    //var cart = '{"cart":{"generated":1327550518906, "total":$179.97, "item":[{"name":"Chair","quantity":2},{"name":"Dog","quantity":1}]}}';
    
    var myJson = jsonParse(cartJson);
    
    var myCart = myJson.cart;
    var generated = myCart.generated;
    
    if(generated>lastCartUpdate){
        lastCartUpdate = generated;
        var contents = document.getElementById("contents");
        contents.innerHTML="";
        
        var items=myCart.item;
        
        for(var I=0; I<items.length; I++){
            var item=items[I];
            var name=item.name;
            var quantity=item.quantity;
            var listItem=document.createElement("li");
            listItem.appendChild(document.createTextNode(name+" x "+quantity));
            contents.appendChild(listItem);
        }
        
        var total = myCart.total;
        document.getElementById("total").innerHTML=total;
    }

}

function removeFromCart(itemCode){
    var request = newXMLHttpRequest();
    request.onreadystatechange = getReadyStateHandler(request, updateCart);
    
    request.open("POST","CartServlet",true);
    request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    
    request.send("action=remove&item="+itemCode);
}
