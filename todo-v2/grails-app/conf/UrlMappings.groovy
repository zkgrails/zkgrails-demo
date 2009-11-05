class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
      
	  "/"(controller:"zul")
      
	  "500"(view:'/error')
	}
}
