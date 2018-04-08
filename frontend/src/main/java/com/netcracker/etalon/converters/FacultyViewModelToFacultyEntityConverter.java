package com.netcracker.etalon.converters;

import com.netcracker.etalon.entities.FacultyEntity;
import com.netcracker.etalon.models.FacultyViewModel;
import org.springframework.core.convert.converter.Converter;

public class FacultyViewModelToFacultyEntityConverter implements Converter<FacultyViewModel, FacultyEntity> {

    @Override
    public FacultyEntity convert(FacultyViewModel facultyViewModel) {

        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setName(facultyViewModel.getName());
        return facultyEntity;
    }
}
