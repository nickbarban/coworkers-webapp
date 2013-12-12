/**
 * Copyright (C) 2013 Anton Grytsenko (anthony.grytsenko@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grytsenko.coworkers.data;

import grytsenko.coworkers.service.Employee;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Helps to map {@link Employee}.
 */
public final class EmployeeMapper {

    /**
     * Maps data from LDAP and database into entity {@link Employee}.
     * 
     * @param ldapEntity
     *            the entity from LDAP.
     * @param dbEntity
     *            the entity from database (optional).
     * 
     * @return the mapped employee.
     */
    public static Employee map(EmployeeLdapEntity ldapEntity,
            EmployeeDbEntity dbEntity) {
        if (ldapEntity == null) {
            return null;
        }

        Employee employee = new Employee();

        Mapper mapper = new DozerBeanMapper();
        mapper.map(ldapEntity, employee);
        if (dbEntity != null) {
            mapper.map(dbEntity, employee);
        }

        return employee;
    }

    private EmployeeMapper() {
    }

}