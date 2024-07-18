package org.example;

import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomTest {

    @ValueSource(longs = {
            1000000L, // ok
            20000000L, //ok
            1700000000L, // same results
            2100000000L, // same results
            2700000000L // ok again
    })
    @ParameterizedTest
    void givenDifferentUpperBounds_shouldProduceDifferentResults(final long baseMax) {
        System.out.println("\n----- baseMax: " + baseMax);

        final long min = 0;
        long offset = 0;

        for (int i = 0; i < 10; i++) {
            RandomDataGenerator random = new RandomDataGenerator(new JDKRandomGenerator(1));

            long actualMax = baseMax + offset;
            long res = random.nextLong(min, actualMax);
            offset += 100_000;

            System.out.printf("min = %d, max = %d, r = %d %n", min, actualMax, res);
        }
    }

/*

Output:

----- baseMax: 1000000
min = 0, max = 1000000, r = 547416
min = 0, max = 1100000, r = 947559
min = 0, max = 1200000, r = 1147678
min = 0, max = 1300000, r = 447778
min = 0, max = 1400000, r = 147864
min = 0, max = 1500000, r = 547939
min = 0, max = 1600000, r = 1548005
min = 0, max = 1700000, r = 448062
min = 0, max = 1800000, r = 1748114
min = 0, max = 1900000, r = 148159

----- baseMax: 20000000
min = 0, max = 20000000, r = 9548907
min = 0, max = 20100000, r = 1748907
min = 0, max = 20200000, r = 14148908
min = 0, max = 20300000, r = 6448908
min = 0, max = 20400000, r = 19148909
min = 0, max = 20500000, r = 11548909
min = 0, max = 20600000, r = 3948909
min = 0, max = 20700000, r = 17048910
min = 0, max = 20800000, r = 9548910
min = 0, max = 20900000, r = 2048910

----- baseMax: 1700000000
min = 0, max = 1700000000, r = 1569548985
min = 0, max = 1700100000, r = 1569548985
min = 0, max = 1700200000, r = 1569548985
min = 0, max = 1700300000, r = 1569548985
min = 0, max = 1700400000, r = 1569548985
min = 0, max = 1700500000, r = 1569548985
min = 0, max = 1700600000, r = 1569548985
min = 0, max = 1700700000, r = 1569548985
min = 0, max = 1700800000, r = 1569548985
min = 0, max = 1700900000, r = 1569548985

----- baseMax: 2100000000
min = 0, max = 2100000000, r = 1569548985
min = 0, max = 2100100000, r = 1569548985
min = 0, max = 2100200000, r = 1569548985
min = 0, max = 2100300000, r = 1569548985
min = 0, max = 2100400000, r = 1569548985
min = 0, max = 2100500000, r = 1569548985
min = 0, max = 2100600000, r = 1569548985
min = 0, max = 2100700000, r = 1569548985
min = 0, max = 2100800000, r = 1569548985
min = 0, max = 2100900000, r = 1569548985

----- baseMax: 2700000000
min = 0, max = 2700000000, r = 2105102418
min = 0, max = 2700100000, r = 266216907
min = 0, max = 2700200000, r = 2423731389
min = 0, max = 2700300000, r = 474645861
min = 0, max = 2700400000, r = 2517160326
min = 0, max = 2700500000, r = 447674781
min = 0, max = 2700600000, r = 2364989229
min = 0, max = 2700700000, r = 164903667
min = 0, max = 2700800000, r = 1946818098
min = 0, max = 2700900000, r = 2306832520
 */

}
