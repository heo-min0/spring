/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.vet.VetRepository;

import java.sql.Connection;
import java.sql.DriverManager;

//@SpringBootTest
class PetclinicIntegrationTests {

	@Autowired
	private VetRepository vets;

//	@Test
//	void testFindAll() throws Exception {
//		vets.findAll();
//		vets.findAll(); // served from cache
//	}

//    static {
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testConnection() {
//        try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@nexgrid2.iptime.org:21521:ORCL",
//            "COMMUTE_DEV",
//            "grid#14ghdeo")){
//            System.out.println("conn");
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

}
