package com.mitron.onlinegrocery.service;

import java.util.List;

import com.mitron.onlinegrocery.domain.models.service.OfferServiceModel;

public interface OfferService {

    List<OfferServiceModel> findAllOffers();
}
