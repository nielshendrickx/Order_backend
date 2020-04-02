package com.switchfully.order.domain.user.system.security;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

class FeatureTest {

    @Test
    void getFeaturesForAdmin_GivenFeatureContainsCreateItem() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList(Role.ADMIN.name()));
        assertThat(actual).contains(Feature.CREATE_ITEM);
    }

    @Test
    void getFeaturesForAdmin_GivenFeatureContainsUpdateItem() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList(Role.ADMIN.name()));
        assertThat(actual).contains(Feature.UPDATE_ITEM);
    }

    @Test
    void getFeaturesForAdmin_GivenFeatureContainsViewCustomers() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList(Role.ADMIN.name()));
        assertThat(actual).contains(Feature.VIEW_CUSTOMERS);
    }

    @Test
    void getFeaturesForAdmin_GivenFeatureContainsShippingOverview() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList(Role.ADMIN.name()));
        assertThat(actual).contains(Feature.SHIPPING_OVERVIEW);
    }

    @Test
    void getFeaturesForAdmin_GivenFeatureContainsItemOVerview() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList(Role.ADMIN.name()));
        assertThat(actual).contains(Feature.ITEM_OVERVIEW);
    }

    @Test
    void getFeaturesForCustomer_GivenFeatureContainsOrderItem() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList(Role.CUSTOMER.name()));
        assertThat(actual).contains(Feature.ORDER_ITEM);
    }

    @Test
    void getFeaturesForCustomer_GivenFeatureContainsOrderHistory() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList(Role.CUSTOMER.name()));
        assertThat(actual).contains(Feature.ORDER_HISTORY);
    }

    @Test
    void getFeaturesForCustomer_GivenFeatureContainsReorder() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList(Role.CUSTOMER.name()));
        assertThat(actual).contains(Feature.REORDER);
    }

    @Test
    void getFeaturesForRoles_GivenNoRolesSupplied_ThenReturnNoFeatures() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList());
        assertThat(actual).isEmpty();
    }





}