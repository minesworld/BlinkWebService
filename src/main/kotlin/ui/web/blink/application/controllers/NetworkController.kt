package ui.web.blink.application.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import ui.web.blink.domain.entities.Camera
import ui.web.blink.domain.entities.CommandStatus
import ui.web.blink.domain.entities.Program
import ui.web.blink.domain.entities.Signal
import ui.web.blink.infrastructure.repositories.NetworkRepository

@RestController
class NetworkController {
    @Autowired
    private lateinit var networkRepository: NetworkRepository


    @GetMapping("/regions/{regionId}/networks/{networkId}/programs")
    fun getProgramList(
        @PathVariable regionId: String,
        @PathVariable networkId: Int,
        @RequestHeader("authToken") authKey: String
    ): List<Program> {
        return networkRepository.getProgramList(authKey, regionId, networkId)
    }

    @GetMapping("/regions/{regionId}/networks/{networkId}/cameras/{cameraId}/config")
    fun getNetworkCameras(
        @PathVariable regionId: String,
        @PathVariable networkId: Int,
        @PathVariable cameraId: Int,
        @RequestHeader("authToken") authKey: String
    ): Camera {
        return networkRepository.getNetworkCameraConfig(authKey, regionId, networkId, cameraId)
    }

    @GetMapping("/regions/{regionId}/networks/{networkId}/cameras/{cameraId}/signals")
    fun getNetworkCameraSignals(
        @PathVariable regionId: String,
        @PathVariable networkId: Int,
        @PathVariable cameraId: Int,
        @RequestHeader("authToken") authKey: String
    ): Signal {
        return networkRepository.getNetworkCameraSignals(authKey, regionId, networkId, cameraId)
    }

    @GetMapping("/regions/{regionId}/networks/{networkId}/commands/{commandId}")
    fun getNetworkCommand(
        @PathVariable regionId: String,
        @PathVariable networkId: Int,
        @PathVariable commandId: Int,
        @RequestHeader("authToken") authKey: String
    ): CommandStatus {
        return networkRepository.getNetworkCommandSatus(authKey, regionId, networkId, commandId)
    }
}