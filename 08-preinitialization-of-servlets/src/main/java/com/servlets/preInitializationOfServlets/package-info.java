package com.servlets.preInitializationOfServlets;
/*- The process of loading a servlet before any request comes in is called preloading or preinitializing a servlet.

- Normally, a container doesn't initialize the servlets as it starts up, it initializes a servlet when it receives a request for that servlet first time.

Some ways to preinitialize a servlet are:

1. A java servlet is initialized when it is called for the first time this is known as the default way of initializing a servlet and is also called as lazy loading.

2. To use the tag non-zero-integer with the deployment descriptor web.xml which loads and initialises the servlet when the server starts.

3. To load a servlet in order of number specified. This load on start up is loaded first and then the higher value servers are loaded after that.*/