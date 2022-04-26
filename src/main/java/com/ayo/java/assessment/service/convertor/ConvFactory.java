package com.ayo.java.assessment.service.convertor;

import com.ayo.java.assessment.service.AreaService;
import com.ayo.java.assessment.service.LengthService;
import com.ayo.java.assessment.service.TemperatureService;
import com.ayo.java.assessment.service.VolumeService;
import com.ayo.java.assessment.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class ConvFactory {

    private final TemperatureService temperatureService;
    private final AreaService areaService;
    private final LengthService lengthService;
    private final VolumeService volumeService;
    private final WeightService weightService;

    @Autowired
    public ConvFactory(final TemperatureService temperatureService,
                       final AreaService areaService,
                       final LengthService lengthService,
                       final VolumeService volumeService,
                       final WeightService weightService) {
        this.temperatureService = temperatureService;
        this.areaService = areaService;
        this.lengthService = lengthService;
        this.volumeService = volumeService;
        this.weightService = weightService;
    }

    /**
     * This method works as a factory which would (based on the conversion type required) return the appropriate
     * implementation of <code>Convertor.java</code>
     *
     * @param type the type of Convertor required, bound by the <code>ConversionType</code> enumerator
     * @return the appropriate Convertor implementation
     *
     * @throws RuntimeException which can occur if a type is being used without an appropriate Convertor being implemented
     */
    public Convertor getConvertor(final ConvType type) {
        if (ConvType.TEMPERATURE.equals(type)) {
            return temperatureService;
        } else if (ConvType.AREA.equals(type)) {
            return areaService;
        } else if (ConvType.LENGTH.equals(type)) {
            return lengthService;
        } else if (ConvType.VOLUME.equals(type)) {
            return volumeService;
        } else if (ConvType.WEIGHT.equals(type)) {
            return weightService;
        } else {
            throw new RuntimeException(format("Could not identify implementation for the conversion type [%s]",
                    type.name()));
        }
    }
}
