import "dotenv/config"; // only CRYPTO_API_KEY here

import axios from "axios";
 
export class BlogClass {
    constructor(blogObj = {}) { 
      this.blogObj = blogObj 
      this.API_KEY = process.env.AWS_API_KEY;
      this.dailytechBaseUrl =  "https://z3noflrq9b.execute-api.us-east-1.amazonaws.com";
    }
   
    // // Data to return crypto Blog   // Blog
    getBlogData() {
     const localVars = {} 
     localVars.path = '/dev/posts' 
  
      this.options = { 
        url: `${this.dailytechBaseUrl}${localVars.path}`,
      };
  
  const sendBlogRequest = async () => {
    try {
      const response = await axios.request(this.options);  
        this.blogObj.blogs = await response.data; 
 
        console.log(this.blogObj.blogs[0].post); 
      }  catch (err) {
      console.log(err)
    }
  }
     sendBlogRequest();
      return this.blogObj.blogs;
    }
   
    getBlogCat() {
      const localVars = {} 
      localVars.path = '/dev/posts' 
   
       this.options = { 
         url: `${this.dailytechBaseUrl}${localVars.path}`,
       };
   
    const sendCategoryRequest = async () => {
      try {
      const response = await axios.request(this.options);
       this.blogObj.blogs = response.data; 
      //  console.log(this.blogObj.blogs[0].cat3); FOR TEST
      } catch(err) {
    console.log(err)
      }
    }
     sendCategoryRequest();
       return this.blogObj.blogs;
     }
  }
   