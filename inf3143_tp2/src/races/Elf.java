/*
 * Copyright 2015 Alexandre Terrasa <alexandre@moz-code.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package races;

import com.google.java.contract.Ensures;

/**
 * Elves are good to cast spells.
 */
public class Elf implements Race {

    private static Elf elfInstance;

    /**
     * Get the singleton instance of Elf.
     *
     * @return the unique Elf instance.
     */
    public static Elf getRace() {
        if (elfInstance == null) {
            elfInstance = new Elf();
        }
        return elfInstance;
    }

    @Override
    @Ensures("result >= 5 && result <= 15")
    public int baseEndurance() {
        return 8;
    }

    @Override
    @Ensures("result >= 5 && result <= 15")
    public int baseIntelligence() {
        return 12;
    }

    @Override
    @Ensures("result >= 5 && result <= 15")
    public int baseStrength() {
        return 8;
    }

    @Override
    @Ensures("result.equals(this.toString())")
    public String toString() {
        return "elf";
    }

}
