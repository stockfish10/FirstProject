package com.firstownproject.FirstProject.service;

import com.firstownproject.FirstProject.model.entity.EventEntity;
import com.firstownproject.FirstProject.model.enums.EventPlaceEnum;
import com.firstownproject.FirstProject.model.enums.EventTypeEnum;
import com.firstownproject.FirstProject.respository.CountryRepository;
import com.firstownproject.FirstProject.respository.EventRepository;
import com.firstownproject.FirstProject.respository.TownRepository;
import com.firstownproject.FirstProject.respository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@Service
public class CreateEvents {



    private final EventRepository eventRepository;
    private final CountryRepository countryRepository;
    private final UserRepository userRepository;
    private final TownRepository townRepository;
    private final Path path = Path.of("src", "main", "resources", "files", "events.txt");
    private final BufferedReader br = new BufferedReader(new FileReader(path.toAbsolutePath().toString()));
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public CreateEvents(EventRepository eventRepository, CountryRepository countryRepository, UserRepository userRepository, TownRepository townRepository) throws FileNotFoundException {
        this.eventRepository = eventRepository;
        this.countryRepository = countryRepository;
        this.userRepository = userRepository;
        this.townRepository = townRepository;
    }

    public void createEvents() {
        if (eventRepository.count() == 0){
            try {
                String line = br.readLine();
                while (line != null) {
                    //      REFERENCE
                    //    (id, address, date, description, event_place, event_type, country_id, organizer_id, town_id)
                    List<String> currentEvent = List.of(line.split("_"));

                    EventEntity newEvent = new EventEntity().
                            setAddress(currentEvent.get(1)).
                            setDate(formatter.parse(currentEvent.get(2))).
                            setDescription(currentEvent.get(3)).
                            setEventPlace(EventPlaceEnum.valueOf(currentEvent.get(4))).
                            setEventType(EventTypeEnum.valueOf(currentEvent.get(5))).
                            setCountry(countryRepository.findById(Long.valueOf(currentEvent.get(6))).get()).
                            setOrganizer(userRepository.findById(Long.valueOf(currentEvent.get(7))).get()).
                            setTown(townRepository.findById(Long.valueOf(currentEvent.get(8))).get());

                    eventRepository.save(newEvent);
                    line = br.readLine();
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        }
    }
}
