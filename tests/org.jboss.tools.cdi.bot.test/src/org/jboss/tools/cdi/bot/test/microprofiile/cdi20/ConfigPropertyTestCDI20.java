/*******************************************************************************
 * Copyright (c) 2021 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributor:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.cdi.bot.test.microprofiile.cdi20;

import java.util.Collection;

import org.eclipse.reddeer.eclipse.ui.perspectives.JavaEEPerspective;
import org.eclipse.reddeer.junit.annotation.RequirementRestriction;
import org.eclipse.reddeer.junit.requirement.matcher.RequirementMatcher;
import org.eclipse.reddeer.requirements.jre.JRERequirement.JRE;
import org.eclipse.reddeer.requirements.openperspective.OpenPerspectiveRequirement.OpenPerspective;
import org.eclipse.reddeer.requirements.server.ServerRequirementState;
import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerRequirement.JBossServer;
import org.jboss.tools.cdi.bot.test.microprofiile.template.ConfigPropertyTestTemplate;

/**
 * 
 * Relevant JIRA: https://issues.redhat.com/browse/JBIDE-27533 
 * Customer issue: https://issues.redhat.com/browse/JBIDE-27762
 * 
 * @author zcervink@redhat.com
 * 
 */
@JRE(cleanup = true)
@JBossServer(state = ServerRequirementState.PRESENT, cleanup = false)
@OpenPerspective(JavaEEPerspective.class)
public class ConfigPropertyTestCDI20 extends ConfigPropertyTestTemplate {

	@RequirementRestriction
	public static Collection<RequirementMatcher> getRestrictionMatcher() {
		return getRestrictionMatcherCDI20();
	}

	public ConfigPropertyTestCDI20() {
		CDIVersion = "2.0";
	}
}
