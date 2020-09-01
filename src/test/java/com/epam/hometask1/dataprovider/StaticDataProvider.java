package com.epam.hometask1.dataprovider;

import com.epam.hometask1.entity.Point;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaticDataProvider {

    @DataProvider(name = "parsed coordinates")
    public static Object[] listOfCoordinates() {
        List<List<Double>> coordinates = new ArrayList<>();
        coordinates.add(0,Arrays.asList(78.36, 32.69, -98.36, -96.32, -7.01, 8.014));
        coordinates.add(1,Arrays.asList(71.01, 0.236, -3.25, -69.3, 3.65, 5.639));
        coordinates.add(2,Arrays.asList(74.36, 25.32, 85.36, 9.36, 4.352, 1.253));
        coordinates.add(3,Arrays.asList(22.30, -9.25, -7.36, 23.36, 9.256, 36.31));
        coordinates.add(4,Arrays.asList(0.36, 0.25, 0.25, 8.36, 9.147, 8.369));
        return  new Object[]{coordinates};
    }

    @DataProvider(name = "read coordinates")
    public static Object[] readCoordinates() {
        List<String> coordinates = new ArrayList<>();
        coordinates.add("123.6559 25.2665 -526.26 -9632.2566 2563.362");
        coordinates.add("583.23 266.3658 -69.36 -87.325 984.359 965.3365");
        coordinates.add("4656.2656 6546.6526 96.36 669.023 -366.25 3326.26");
        coordinates.add("vb 56.36 vd.6 sw.3356");
        coordinates.add("2.3 12.3 456.6");
        coordinates.add("54.56 98 936.9 366.3 9.99 -36.9");
        coordinates.add("78.36 32.69 -98.36 -96.32 -7.01 8.014");
        coordinates.add("71.01 0.236 -3.25 -69.3 3.65 5.639");
        coordinates.add("74.36 25.32 85.36 9.36 4.352 1.253");
        coordinates.add("22.30 -9.25 -7.36 23.36 9.256 36.31");
        coordinates.add("0.36 0.25 0.25 8.36 9.147 8.369");
        coordinates.add("7.36 9.236 -9.36 -47.36 -78.36 10.336");
        coordinates.add("4.236 826.36 246.369 488.23 700.07 120.36");
        coordinates.add("36.365 147 253.025 782.0023 696.652 72.026");
        coordinates.add("96.023 963.52 564.464 45.565 236.256 856.655");
        coordinates.add("56.02 496.565 5663.6598 6893.777 543.556 6549.5466");
        coordinates.add("333.22365.4506 655464.56 36.546469.65546");
        return  new Object[]{coordinates};
    }
}
