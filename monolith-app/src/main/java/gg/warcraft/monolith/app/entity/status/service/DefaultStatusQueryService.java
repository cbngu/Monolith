package gg.warcraft.monolith.app.entity.status.service;

import com.google.inject.Inject;
import gg.warcraft.monolith.api.entity.status.Status;
import gg.warcraft.monolith.api.entity.status.service.StatusQueryService;
import gg.warcraft.monolith.api.entity.status.service.StatusRepository;

import java.util.UUID;

public class DefaultStatusQueryService implements StatusQueryService {
    private final StatusRepository statusRepository;

    @Inject
    public DefaultStatusQueryService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status getStatus(UUID entityId) {
        return statusRepository.getStatus(entityId);
    }
}
