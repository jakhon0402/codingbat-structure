package com.example.codingbatstructure.service;

import com.example.codingbatstructure.entity.Language;
import com.example.codingbatstructure.payload.ApiResponse;
import com.example.codingbatstructure.payload.LanguageDto;
import com.example.codingbatstructure.repository.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    LanguageRepo languageRepo;

    public List<Language> getLanguages(){
        return languageRepo.findAll();
    }

    public Language getLanguage(Integer id){
        Optional<Language> optionalLanguage = languageRepo.findById(id);
        return optionalLanguage.orElse(null);
    }

    public ApiResponse addLanguage(LanguageDto languageDto){
        Language language = new Language();
        language.setName(languageDto.getName());
        languageRepo.save(language);
        return new ApiResponse("Language qo'shildi !",true);
    }

    public ApiResponse editLanguage(LanguageDto languageDto,Integer id){
        Optional<Language> optionalLanguage = languageRepo.findById(id);
        if(!optionalLanguage.isPresent()){
            return new ApiResponse("Bunday idlik language mavjud emas !", false);
        }
        Language language = optionalLanguage.get();
        language.setName(languageDto.getName());
        languageRepo.save(language);
        return new ApiResponse("Language tahrirlandi !", true);
    }

    public ApiResponse deleteLanguage(Integer id){
        Optional<Language> optionalLanguage = languageRepo.findById(id);
        if(!optionalLanguage.isPresent()){
            return new ApiResponse("Bunday idlik language mavjud emas !", false);
        }
        languageRepo.delete(optionalLanguage.get());
        return new ApiResponse("Language o'childi !", true);
    }
}
