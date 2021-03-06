/*
 * Copyright (c) 2020 Adrian Dobre - GPL v3 License.
 *
 * This file is subject to the terms and conditions defined in
 * the 'LICENSE.txt' file, which is part of this source code package.
 */

package ui.web.blink.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Session(
    @JsonProperty("authtoken")
    val authToken: AuthToken,
    val account: Account,
    val client: Client,
    val region: Region,
    val lockoutTimeRemaining: Int,
    val forcePasswordReset: Boolean,
    val allowPinResendSeconds: Int
)