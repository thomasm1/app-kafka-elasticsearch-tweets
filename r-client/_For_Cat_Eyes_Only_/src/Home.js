import React, { Component } from 'react';
// import 'home.css';
import logo from './images/MOMs_Logo.svg';
import Nav from './js/components/Nav';
import Todos from './Components/Todos'; 
import Projects from './Components/Projects';
import AddProject from './Components/AddProject'; 

import { csv } from 'd3-request';
import uuid from 'uuid';
import $ from 'jquery';

export default class Home extends Component {
    constructor(props) { 
      super(props);   // tm: will revisit this to see if precarious.
      this.state = {
      projects: [],
      todos:[]
     }
    }

    getTodos(){ // jQuery AJAX request  Require jQuery!
   $.ajax({
      url: 'https://jsonplaceholder.typicode.com/todos',
      dataType:'json',
      cache: false,
      success: function(data){
        this.setState({todos: data}, function(){
          console.log(this.state)
        });
      }.bind(this),
      error: function(xhr, status, err){
    console.log(err);
      }
    });
    }
    getProjects(){
      // this is life-cycle method  
    this.setState({projects: [  //  data will go to componentWillMount();
  {
        id:uuid.v4(),
        title: ' title 1 ', 
        category: 'Page One'
       },{
        id:uuid.v4(),
        title: ' title  2 ',
        category: 'Page Two'
       },{
        id:uuid.v4(),
        title: ' title  3 ', 
        category: 'Page Three'
       },{
        id:uuid.v4(),
        title: ' title  4', 
        category: 'Page Four'
  }
       ]});
    }
    componentWillMount(){ //  data removed, placed into getProjects();
    this.getProjects();
    this.getTodos();

    csv('../data/bp-prod-1707.csv', (error, data) => {
      if (error) {
        this.setState({loadError: true});
      }
      this.setState({
        data: data.map(d => ({...d, x: Number(d.volume), y: Number(d.energy_content)}))
      });
    })
    }
    
    componentDidMount(){
    this.getTodos();
    } 
    handleAddProject(project){
      console.log(project);
      let projects = this.state.projects;
      projects.push(project);
      this.setState({projects:projects});
    }
    handleDeleteProject(id){
      let projects= this.state.projects;
      let index = projects.findIndex(x => x.id === id);
      projects.splice(index, 1);
      this.setState({projects:projects});
    }	
	
  render() {
    return ( 
 <div className="row home"> 
  <div className="home-header">
 <img src={logo} className="home-logo" alt="Xpansiv logo" />
 <h3>Portfolio Management</h3>
</div>
 <div className="left col s12 m4">
   <div className="icon-block">
     <h2 className="center light-blue-text"><i className="material-icons">flash_on</i></h2>
     <h5 className="center">Speeds up development</h5>
       </div>
 </div>

 <div className="right col s12 m4">
   <div className="icon-block">
     <h2 className="center light-blue-text"><i class="material-icons">group</i></h2>
     <h5 className="center">User Experience Focused</h5>

     <hr />
      <Projects projects={this.state.projects} onDelete={this.handleDeleteProject.bind(this)} />
       <hr />
    
   </div>
 </div>

 <div className="center col s12 m4">
   <div className="icon-block">
     <h2 className="center light-blue-text"><i class="material-icons">settings</i></h2>
     <h5 className="center">Api Import</h5>
<ul>
<li>  <Todos todos={this.state.todos} /> </li>
</ul>
   </div>
 </div>
</div>
 
    );
  }
}
