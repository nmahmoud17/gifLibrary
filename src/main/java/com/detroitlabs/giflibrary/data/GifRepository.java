package com.detroitlabs.giflibrary.data;

import com.detroitlabs.giflibrary.model.Gif;
import org.springframework.stereotype.Component;

import java.security.AlgorithmConstraints;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("toobad", LocalDate.of(2019, 2, 23), "Erika Languirand", true, 3),
            new Gif("exhausting", LocalDate.of(2019, 2, 23), "Jen Bloomer", false, 2),
            new Gif("headtilt", LocalDate.of(2019, 2, 23), "Dan Newport", true,1),
            new Gif("corgibeg", LocalDate.of(2019, 2, 23), "Matt of Lansing", false, 1),
            new Gif("hugemistake", LocalDate.of(2019, 2, 23), "Erika Languirand", true, 3),
            new Gif("whatisaid", LocalDate.of(2019, 2, 23), "Dan Newport", true, 2)
    );

    public Gif findByName(String name){
        for (Gif gif:ALL_GIFS) {
            if (gif.getName().equalsIgnoreCase(name)){
                return gif;
            }
        }
        return null;
    }
    public List<Gif> findGifByCategoryId(int id){

        List<Gif> gifsInCategory = new ArrayList<>();
        for (Gif gif:ALL_GIFS) {
            if (gif.getId() == id){
                gifsInCategory.add(gif);
            }
        }
        return gifsInCategory;
    }

    public List<Gif> searchResults(String gifName){
        List<Gif> gifsFromSearch = new ArrayList<>();
        for (Gif gif: ALL_GIFS){
            if (ALL_GIFS.contains(gifName)){
                gifsFromSearch.add(gif);
            }
        }
        return gifsFromSearch;
    }


    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }
}
