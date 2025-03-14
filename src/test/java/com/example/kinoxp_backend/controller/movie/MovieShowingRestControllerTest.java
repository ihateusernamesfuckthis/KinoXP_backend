package com.example.kinoxp_backend.controller.movie;

import com.example.kinoxp_backend.dto.movie.MovieShowingDTO;
import com.example.kinoxp_backend.model.movie.Movie;
import com.example.kinoxp_backend.model.movie.MovieHall;
import com.example.kinoxp_backend.model.movie.MovieShowing;
import com.example.kinoxp_backend.service.movie.MovieHallService;
import com.example.kinoxp_backend.service.movie.MovieService;
import com.example.kinoxp_backend.service.movie.MovieShowingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MovieShowingRestController.class)
class MovieShowingRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MovieShowingService movieShowingService;

    @MockBean
    private MovieService movieService;

    @MockBean
    private MovieHallService movieHallService;

    @Test
    void createMovieShowing_ShouldReturnCreatedShowing() throws Exception {
        Movie movie = new Movie();
        movie.setId(1);
        MovieHall movieHall = new MovieHall();
        movieHall.setId(1);

        MovieShowing movieShowing = new MovieShowing();
        movieShowing.setId(1);
        movieShowing.setMovie(movie);
        movieShowing.setMovieHall(movieHall);
        movieShowing.setShowDate(LocalDate.of(2025, 5, 1));
        movieShowing.setStartTime(LocalTime.of(18, 0));

        MovieShowingDTO dto = new MovieShowingDTO();
        dto.setMovieId(1);
        dto.setMovieHallId(1);
        dto.setShowDate(LocalDate.of(2025, 5, 1));
        dto.setStartTime(LocalTime.of(18, 0));

        Mockito.when(movieService.getMovieById(1)).thenReturn(movie);
        Mockito.when(movieHallService.getMovieHallById(1)).thenReturn(movieHall);
        Mockito.when(movieShowingService.saveMovieShowing(any(MovieShowing.class))).thenReturn(movieShowing);

        mockMvc.perform(post("/api/movieShowingList")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void getAllMovieShowings_ShouldReturnList() throws Exception {
        Mockito.when(movieShowingService.getAllMovieShowings()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/movieShowingList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getMovieShowingsByMovieId_ShouldReturnList() throws Exception {
        int movieId = 1;

        Mockito.when(movieShowingService.getMovieShowingsByMovieId(movieId)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/movieShowingList/{movieId}", movieId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getMovieShowingsByDateRange_ShouldReturnList() throws Exception {
        LocalDate startDate = LocalDate.of(2025, 5, 1);
        LocalDate endDate = LocalDate.of(2025, 5, 10);

        Mockito.when(movieShowingService.getMovieShowingsByDateRange(startDate, endDate)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/movieShowingList/range")
                        .param("startDate", startDate.toString())
                        .param("endDate", endDate.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }


    @Test
    void getMovieShowingsByMovieId_ShouldReturnListWithData() throws Exception {
        int movieId = 1;

        List<MovieShowing> movieShowings = new ArrayList<>();
        movieShowings.add(new MovieShowing());
        movieShowings.add(new MovieShowing());

        Mockito.when(movieShowingService.getMovieShowingsByMovieId(movieId)).thenReturn(movieShowings);

        mockMvc.perform(get("/api/movieShowingList/{movieId}", movieId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()", is(2)));
    }
}
