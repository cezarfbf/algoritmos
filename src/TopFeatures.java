// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class TopFeatures
{
    public static void main(String[] args) {

        List<String> possibleFeatures = new ArrayList<>();
        possibleFeatures.add("storage");
        possibleFeatures.add("battery");
        possibleFeatures.add("hover");

        List<String> featureRequests = new ArrayList<>();
        featureRequests.add("sadfsd sdjkh  sdfksdf storage");
        featureRequests.add("sadfsd storage sdjkh  sdfksdf storage ");
        featureRequests.add("sadfsd hover  sdfksdf storage");

        popularNFeatures(3,2,possibleFeatures,3,featureRequests)
                .forEach(System.out::println);


    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests)
    {
        // WRITE YOUR CODE HERE

        if (topFeatures > possibleFeatures.size()) return new ArrayList<>(possibleFeatures);

        List<String> output = new ArrayList();
        Map<String, Integer> map = new HashMap();

        possibleFeatures.forEach(pf -> map.put(pf.toLowerCase(),0));

        for (String request : featureRequests) {
            for (String feature : possibleFeatures) {
                if (request.toLowerCase().contains(feature))
                    map.merge(feature, 1, Integer::sum);
            };
        };
         map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(topFeatures)
                .collect(Collectors.toList())
                ;
        return new ArrayList<>();
    }
    // METHOD SIGNATURE ENDS
}