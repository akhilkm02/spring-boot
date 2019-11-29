import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

import {Header} from './components/Header';  
import {Images} from './components/Images'; 
import {Attributes} from './components/Attributes'; 
import {Error} from './components/Error'; 

class App extends Component {
    constructor (props) {
          super(props)
          this.state = { 
            error: null,
         isLoaded: false,
          } 
    }
    
    componentDidMount() {
        let url=window.location.href;
        let productDetails;
        if(window.location.port==3000 || window.location.port==5000){
           url='http://localhost:3012/pdp'+window.location.pathname;
        }else{
           url=url.replace(window.location.pathname,"/logic/pdp"+window.location.pathname);//crap code need to remove
        }
        fetch(url)
          .then(res => res.json())
          .then(
            (result) => {
                 this.setState({
                      isLoaded: true,
                      productDetails: result
                 });
            },
            // Note: it's important to handle errors here
            // instead of a catch() block so that we don't swallow
            // exceptions from actual bugs in components.
            (error) => {
              this.setState({
                isLoaded: true,
                error
              });
            }
          )

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
        if (this.state.error) {
          return <div>Error: {this.state.error.message}</div>;
        } else if (this.state.productDetails==null && this.state.isLoaded){
            return (<Error/>);
        }else if (!this.state.isLoaded) {
          return <div>Loading...</div>;
        } else {
            console.log("here iam "+this.state.productDetails);
            const{productId,productName,rating,price,attributes1,attributes2,attributes3,attrName1,attrName2,attrName3,img1,img2,img3,img4}=this.state.productDetails;
            const mainImg=img1.replace("pdp_thumb2","pdp_main"); 

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
}

export default App;
