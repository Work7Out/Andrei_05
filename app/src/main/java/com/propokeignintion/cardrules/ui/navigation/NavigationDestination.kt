package com.propokeignintion.cardrules.ui.navigation

import com.propokeignintion.cardrules.domain.utils.INFO_SCREEN
import com.propokeignintion.cardrules.domain.utils.LIST_RULE_SCREEN
import com.propokeignintion.cardrules.domain.utils.LIST_TESTS_SCREEN
import com.propokeignintion.cardrules.domain.utils.LOADING_SCREEN
import com.propokeignintion.cardrules.domain.utils.RULE_4_SCREEN
import com.propokeignintion.cardrules.domain.utils.RULE_SCREEN
import com.propokeignintion.cardrules.domain.utils.START_SCREEN
import com.propokeignintion.cardrules.domain.utils.TEST_SCREEN
import com.propokeignintion.cardrules.domain.utils.WEB_SCREEN

sealed class NavigationDestination (val destination: String){
    data object StartDestination: NavigationDestination(START_SCREEN)
    data object InfoDestination: NavigationDestination(INFO_SCREEN)
    data object ListTestsDestination: NavigationDestination(LIST_TESTS_SCREEN)
    data object ListRulesDestination: NavigationDestination(LIST_RULE_SCREEN)
    data object LoadingDestination: NavigationDestination(LOADING_SCREEN)
    data object WebDestination: NavigationDestination(WEB_SCREEN)
    data object RuleDestination: NavigationDestination("$RULE_SCREEN/{idRule}")
    data object Rule4Destination: NavigationDestination("$RULE_4_SCREEN/{idRule}")
    data object TestDestination: NavigationDestination("$TEST_SCREEN/{idTest}")
}
