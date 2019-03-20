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
        if(this.props.img2){
         var mobImg2=this.props.img2.replace("pdp_thumb2","pdp_main");
         var mobImg3=this.props.img3.replace("pdp_thumb2","pdp_main")
         var mobImg4=this.props.img4.replace("pdp_thumb2","pdp_main")
        }

    	if(this.state.status==0){
    		this.state.mainImage=this.props.mainImg;	
    	}
        return (
        		<div className="container">
        		  <div className="row">
        		    <div className="col-lg-6 col-md-12 col-sm-12 hidden-sm hidden-md hidden-xs">
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
                    <div className="hidden-lg hidden-xl">
                          <div id="myCarousel" className="carousel slide" data-ride="carousel">
                          
                            <ol className="carousel-indicators">
                              <li data-target="#myCarousel" data-slide-to="0" className="active"></li>
                              <li data-target="#myCarousel" data-slide-to="1"></li>
                              <li data-target="#myCarousel" data-slide-to="2"></li>
                              <li data-target="#myCarousel" data-slide-to="3"></li>
                            </ol>

  
                            <div className="carousel-inner">
                              <div className="item active">
                                <img src={this.state.mainImage} className="img-square sideImg" alt="Los Angeles" />
                              </div>

                              <div className="item">
                                <img src={mobImg2} className="img-square sideImg" alt="Chicago" />
                              </div>
                            
                              <div className="item">
                                <img src={mobImg3} className="img-square sideImg"  alt="New york" />
                              </div>
                              
                              <div className="item">
                                <img src={mobImg4} className="img-square sideImg" alt="New york" />
                              </div>
                              
                            </div>

                            
                            <a className="left carousel-control" href="#myCarousel" data-slide="prev">
                              <span className="glyphicon glyphicon-chevron-left"></span>
                              <span className="sr-only">Previous</span>
                            </a>
                            <a className="right carousel-control" href="#myCarousel" data-slide="next">
                              <span className="glyphicon glyphicon-chevron-right"></span>
                              <span className="sr-only">Next</span>
                            </a>
                          </div>
                    </div>
      			  </div>	
      		    </div>
        );   
    }
	
}