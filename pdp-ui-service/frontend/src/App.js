import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

import {Header} from './components/Header';  
import {Images} from './components/Images'; 
import {Attributes} from './components/Attributes'; 

class App extends Component {
    constructor () {
    	  super()
    	  this.state = { 

    	  } 
    } 
    
    componentDidMount() {
    	if (typeof window !== 'undefined' && window.location.pathname != "/") {
    		var url=window.location.href;
            if(window.location.port==3000 || window.location.port==5000){
               url='http://localhost:3012/pdp'+window.location.pathname;
            }else{
               url=url.replace(window.location.pathname,"/logic/pdp"+window.location.pathname);//crap code need to remove
            }
            fetch(url)
            .then(response => response.json()) 
            .then(message => {
                this.setState({message: message});
            });
    	}

	    setTimeout(function(){ 
			var url="http://localhost:3015/inventory/getUserView"+window.location.pathname;
			//url=url.replace(window.location.pathname,"/logic/pdp"+window.location.pathname);//crap code need to remove
			//url='http://localhost:3012/pdp'+window.location.pathname;
	        fetch(url)
	        .then(response => response.text()) 
	        .then(message => {
	            console.log(message);
	        });
        }, 1000);
    	
    }

    render() { 
        var productDetails=this.state.message;
        var attributes1=[];
        var attributes2=[];
        var attributes3=[];
        if(productDetails  && productDetails.productId !=null){
        	 var productName =productDetails.productName;
        	 var productId=productDetails.productId;
        	 var rating=productDetails.rating;
        	 var price=productDetails.price;
        	 attributes1=productDetails.attributes1;
        	 attributes2=productDetails.attributes2;
        	 attributes3=productDetails.attributes3;
        	 var attrName1=productDetails.attrName1;
        	 var attrName2=productDetails.attrName2;
        	 var attrName3=productDetails.attrName3;
        	 var img1=productDetails.img1;
        	 var img2=productDetails.img2;
        	 var img3=productDetails.img3;
        	 var img4=productDetails.img1;
        	 var mainImg=productDetails.img1.replace("pdp_thumb2","pdp_main");
        }

        return (
	        <div className="containerMain">				
	          <div className="jumbotron">		
	            <Header/>
	          </div>
	          <div className="col-lg-6 col-md-12 col-sm-12">	
	              <Images mainImg={mainImg}  img1={img1} img2={img2} img3={img3} img4={img4}/>
	           </div>
		          <div className="col-lg-6 col-md-12 col-sm-12 text-left pro-desc">		
	              <Attributes attrName1={attrName1} attrName2={attrName2} attrName3={attrName3} productName={productName} price={price} attributes1={attributes1} attributes2={attributes2} attributes3={attributes3}  rating={rating}/>
	           </div>
	        </div>
        );   
    }
}

export default App;
