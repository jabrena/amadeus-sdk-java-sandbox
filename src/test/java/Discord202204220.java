import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * Doubt about the following endpoints:
 * https://developers.amadeus.com/self-service/category/air/api-doc/airport-and-city-search/api-reference
 */
public class Discord202204220 {

    @Test
    public void given_test_environment_when_call_airport_locations_in_madrid_then_Ok() throws ResponseException {

        //Given
        Amadeus amadeus = Amadeus.builder(System.getenv()).build();

        Params params = Params.with("keyword", "MAD").and("subType", Locations.AIRPORT);

        //When
        Location[] locations = amadeus.referenceData.locations.get(params);

        //Then
        then(locations.length).isGreaterThan(0);

        Arrays.stream(locations)
            .map(Location::getAddress)
            .map(Location.Address::getCountryName)
            .forEach(System.out::println);
    }

    @Test
    public void given_test_environment_when_call_city_locations_in_madrid_then_Ok() throws ResponseException {

        //Given
        Amadeus amadeus = Amadeus.builder(System.getenv()).build();

        Params params = Params.with("keyword", "MAD").and("subType", Locations.CITY);

        //When
        Location[] locations = amadeus.referenceData.locations.get(params);

        //Then
        then(locations.length).isGreaterThan(0);

        Arrays.stream(locations)
            .map(Location::getAddress)
            .map(Location.Address::getCountryName)
            .forEach(System.out::println);
    }

}
