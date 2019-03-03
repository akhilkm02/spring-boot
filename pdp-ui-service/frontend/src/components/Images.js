import React, {Component} from 'react';

export class Images extends Component{
	
    constructor(props) {
        super(props);
        this.state = {
        	mainImage: "",
        	status: 0	
        };
    }
	
	changeMainImage(img){		
		 img=img.replace("pdp_thumb2","pdp_main");
		 this.setState({
			 mainImage: img,
			 status:1
		 });
	} 
    render() { 
    	if(this.state.status==0){
    		this.state.mainImage=this.props.mainImg;	
    	}
        return (
        		<div className="container">
        		  <div className="row">
        		    <div className="col-lg-6 col-md-12 col-sm-12">
        			   <div className="img-wrapper row">
        			    <div className="text-center smallImg hidden-sm hidden-md hidden-xs">
        				 <div className="well active smallImgContainer">
        				   <img src={this.props.img1} className="img-square sideImg" id="img1" onClick={()=>this.changeMainImage(this.props.img1)} alt="Cinque Terre"  height="157"/> 
        				  </div>
        		          <div className="well smallImgContainer">		  
        				   <img src={this.props.img2} className="img-square sideImg" id="img2" onClick={()=>this.changeMainImage(this.props.img2)} alt="Cinque Terre"  height="157"/> 
        				  </div>
        		          <div className="well smallImgContainer">		 
        				   <img src={this.props.img3} className="img-square sideImg" id="img3" onClick={()=>this.changeMainImage(this.props.img3)}  alt="Cinque Terre"  height="157"/> 
        				  </div>
        		          <div className="well smallImgContainer">		 
        				   <img src={this.props.img4} className="img-square sideImg"  id="img4"onClick={()=>this.changeMainImage(this.props.img4)} alt="Cinque Terre"  height="157"/> 
        				  </div> 
        				</div>
        			    <div className="text-center bigImage">
        				  <img src={this.state.mainImage} className="img-square" alt="Cinque Terre"  height="665"/> 
        				</div>
        			  </div>	
        		    </div>
      			  </div>	
      		    </div>
        );   
    }
	
}