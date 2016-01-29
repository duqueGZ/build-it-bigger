/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.udacity.backend;

import com.example.udacity.jokeprovider.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "jokeServerApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.udacity.example.com",
    ownerName = "backend.udacity.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke(@Named("locale") String locale) {
        MyBean response = new MyBean();
        String joke = JokeProvider.getInstance().tellJoke(locale);
        response.setData(joke);

        return response;
    }

}
