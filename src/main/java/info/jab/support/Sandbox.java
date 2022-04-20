package info.jab.support;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sandbox {

    private static Logger logger = LoggerFactory.getLogger(Sandbox.class);

    public static void main(String[] args) throws ResponseException {

        Amadeus amadeus = Amadeus
            .builder(System.getenv())
            .setLogLevel("debug")
            .build();

        Location[] locations = amadeus.referenceData.locations.get(Params
            .with("keyword", "MAD")
            .and("subType", Locations.AIRPORT));

        String jsonInString = new Gson().toJson(locations);

        logger.info(jsonInString);
    }

}
