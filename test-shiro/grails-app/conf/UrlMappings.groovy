class UrlMappings {
	static excludes = ['/zkau/*']
	static mappings = {
	  "/$controller/$action?/$id?"{
		  constraints {
			 // apply constraints here
		  }
	  }
	  "/"(view:"/index")
	  "500"(view:'/error')
	}
}
