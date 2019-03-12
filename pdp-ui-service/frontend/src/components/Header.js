import React, {Component} from 'react';


export class Header extends Component{
	
    render() { 
        return (
        		  <div className="jumbotron">
        			<div className="container">
        				<nav className="navbar1 navbar-default">
        					 <div className="navbar-header">
        						<button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        						  <span className="sr-only">Toggle navigation</span>
        						  <span className="icon-bar"></span>
        						  <span className="icon-bar"></span>
        						  <span className="icon-bar"></span>
        						</button>
        						<a className="navbar-brand" href=""><img className="img-responsive center-block" src="https://www.jjill.com/wcsstore/JJillStorefrontAssetStore/assests/images/jjill-logo.png" alt="Jjill logo"/></a>
        					  </div>
        					  <div id="navbar" className="navbar-collapse collapse">
        						<ul className="nav navbar-nav">
        						   <li className="active1"><a href="">NEW ARRIVALS</a></li>
        						   <li><a href="">CLOATHING</a></li>
        						   <li><a href="">SHOE&ACCESSORIES</a></li>
        						   <li><a href="">COLLECTIONS</a></li>
        						   <li><a href="">SALES</a></li>
        						</ul>
        						<ul className="nav navbar-nav navbar-right">
        						  <li className="active1"><a href="./">STORES <span className="sr-only">(current)</span></a></li>
        						  <li><a href="../navbar-static-top/">MY ACCOUNT</a></li>
        						  <li><a href="../navbar-fixed-top/"><img className="img-responsive center-block cartimg" src="/static/media/cart.png" alt="Jjill logo"/></a></li>
        						</ul>
        					  </div>
        				</nav>
        			</div>
        		</div>
        );   
    }
	
}