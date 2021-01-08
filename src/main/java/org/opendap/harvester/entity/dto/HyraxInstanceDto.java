/**
 Copyright (c) 2019 OPeNDAP, Inc.
 Please read the full copyright statement in the file LICENSE.

 Authors: 
	James Gallagher	 <jgallagher@opendap.org>
    Samuel Lloyd	 <slloyd@opendap.org>

 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public
 License as published by the Free Software Foundation; either
 version 2.1 of the License, or (at your option) any later version.

 This library is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public
 License along with this library; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA

 You can contact OPeNDAP, Inc. at PO Box 112, Saunderstown, RI. 02874-0112.
*/

/**
 * Data transfer object for returning results form BE to FE.
 */
package org.opendap.harvester.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public class HyraxInstanceDto {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String reporterUrl;
    @Getter @Setter
    private Long ping = 0L;
    @Getter @Setter
    private int log = 0;
    @Getter @Setter
    private String versionNumber;
    @Getter @Setter
    private LocalDateTime registrationTime;
    @Getter @Setter
    private LocalDateTime lastAccessTime;
    @Getter @Setter
	private LocalDateTime lastSuccessfulPull;
	@Getter @Setter
	private LocalDateTime lastErrorTime;
	@Getter @Setter
	private Boolean accessible = true;
	@Getter @Setter
	private Boolean reporterRunning = true;
	@Getter @Setter
	private Boolean serverRunning = true;
    @Getter @Setter
    private Boolean active = false;
    @Getter @Setter
    private UUID serverUUID;
}

