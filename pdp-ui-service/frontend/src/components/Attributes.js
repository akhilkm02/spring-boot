import React, {Component} from 'react';
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';


export class Attributes extends Component{
	
    constructor(props) {
        super(props);
        let currentComponent = this;
        this.state = {
        	inventoryText: "Inventory information is not available",
        	viewersText  : "Loading the infomation ..."
        };
        
        //viewers
        var stompClientv=null;
		var socketv = new SockJS('http:'+window.location.origin.split(':')[1]+':3015/inventoryService');
		stompClientv = Stomp.over(socketv); 
		stompClientv.connect({"productId":window.location.pathname.replace("/","")}, function(frame) {
			console.log('Connected: ' + frame);
			stompClientv.subscribe('/topic/product.'+window.location.pathname.replace("/",""), function(viewers) {
				var content=JSON.parse(viewers.body).content;
				console.log("count of viewers is "+content);
				currentComponent.setState({
					viewersText: content,
				 });
			});
		}); 
        
        //inventory info
		var stompClient=null;
		var socket = new SockJS('http:'+window.location.origin.split(':')[1]+':3015/inventoryService');
		stompClient = Stomp.over(socket);
		stompClient.connect({"productId":"all"}, function(frame) {
			console.log('Connected: ' + frame);
			stompClient.subscribe('/topic'+window.location.pathname, function(data) {
				var content=JSON.parse(data.body).content;	
				var invMessage=JSON.parse(content).message;
				currentComponent.setState({
					inventoryText: invMessage,
				 });
			});
		});        
    }
    
    componentDidMount(){

    }
    
    render() { 
        return (
        
          <div className="rowProductHeading">
             <div className="productHeading">
                <h1 className="productHeadingtext textColor"  aria-level="1" itemProp="name">{this.props.productName}</h1>
                   <div className="star-ratings">
                      <span className="fa fa-star checked"></span>
                      <span className="fa fa-star checked"></span>
                      <span className="fa fa-star checked"></span>
                      <span className="fa fa-star"></span>
                      <span className="fa fa-star"></span> {this.props.rating} (5)
                   </div>
                   <div className="row product-attribute attr2">
                      <div className="col-xs-4 col-lg-2 pdp-attribute-col">
                         <h4 className="pdp-attribute-label textColor"> PRICE </h4>
                      </div>
                      <div className="col-xs-8 col-lg-10 pdp-value-col textColor ">
                         <div className="btn-group btn-group-lg pdp-attribute-label textColor" role="group">
                            <span className="price pull-left priceMain">${this.props.price}</span>  
                         </div>
                      </div>
                   </div>
                   <div className="row product-attribute attr3">
                      <div className="col-xs-4 col-lg-2 pdp-attribute-col">
                         <h4 className="pdp-attribute-label textColor"> {this.props.attrName1}  </h4>
                      </div>
                      <div className="col-xs-8 col-lg-10 pdp-value-col textColor ">
                         <div className="btn-group btn-group-lg pdp-attribute-label textColor" role="group">
                            {this.props.attributes1.map((attr,i) => <button type="button" key={i} className="btn btn-default attribute-col">{attr}</button>)}
                         </div>
                      </div>
                   </div>
                   <div className="row product-attribute attr3">
                      <div className="col-xs-4 col-lg-2 pdp-attribute-col">
                         <h4 className="pdp-attribute-label textColor"> {this.props.attrName2} </h4>
                      </div>
                      <div className="col-xs-8 col-lg-10 pdp-value-col textColor ">
                         <div className="btn-group btn-group-lg pdp-attribute-label textColor" role="group">
                            {this.props.attributes2.map((attr,i) => <button type="button" key={i} className="btn btn-default attribute-col">{attr}</button>)}
                         </div>
                      </div>
                   </div>
                   <div className="row product-attribute attr3">
                      <div className="col-xs-4 col-lg-2 pdp-attribute-col">
                         <h4 className="pdp-attribute-label textColor"> {this.props.attrName3} </h4>
                      </div>
                      <div className="col-xs-8 col-lg-10 pdp-value-col textColor ">
                         <div className="btn-group btn-group-lg pdp-attribute-label textColor" role="group">
                            {this.props.attributes3.map((attr,i) => <button type="button" key={i} className="btn btn-default attribute-col">{attr}</button>)}
                         </div>
                      </div>
                   </div>
                   <div className="row product-attribute QTY">
                      <div className="col-xs-4 col-lg-2 pdp-attribute-col">
                         <h4 className="pdp-attribute-label textColor"> QTY:  </h4>
                      </div>
                      <div className="col-xs-8 col-lg-10 pdp-value-col textColor ">
                         <span className="pos-relative">
                            <select name="quantity"  className="quantity"  id="quantity_77131">
                               <option>1</option>
                               <option>2</option>
                               <option>3</option>
                               <option>4</option>
                            </select>
                         </span>
                      </div>
                   </div>
                   <div className="row product-attribute inventory">
                      <div className="col-sm-6 col-md-6 col-xs-4 col-lg-2 pdp-attribute-col">
                         <h4 className="pdp-attribute-label textColor"> Inventory </h4>
                      </div>
                      <div className="col-sm-6 col-md-6 col-sm-8 col-xs-8 col-lg-10 pdp-value-col textColor ">
                        
                            <p className="pdp-attribute-label textColor" id="inventory-message">{this.state.inventoryText}</p>
                        
                      </div>
                   </div>
                   <div className="row product-attribute viewers">
                      <div className="col-sm-6 col-md-6 col-xs-4 col-lg-2 pdp-attribute-col">
                         <h4 className="pdp-attribute-label textColor"> Viewers </h4>
                      </div>
                      <div className="col-sm-6 col-md-6 col-xs-8 col-lg-10 pdp-value-col textColor ">
                         <span className="pos-relative" id="viewers-info">
                            <p className="pdp-attribute-label textColor" id="viewers-message">{this.state.viewersText}</p>
                         </span>
                      </div>
                   </div>
                   <div className="row product-attribute add to cart">
                      <div className="col-xs-12 col-lg-12 col-sm-12  col-md-12 text-center">
                         <div className="productPageAdd2Cart">
                            ADD TO CART
                         </div>
                      </div>
                   </div>
               
             </div>
          </div>

        );   
    }
	
}