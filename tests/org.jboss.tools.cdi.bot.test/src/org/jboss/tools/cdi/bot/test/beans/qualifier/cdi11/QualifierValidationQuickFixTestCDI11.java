/*******************************************************************************
 * Copyright (c) 2010-2018 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributor:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.cdi.bot.test.beans.qualifier.cdi11;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.reddeer.eclipse.ui.perspectives.JavaEEPerspective;
import org.eclipse.reddeer.junit.annotation.RequirementRestriction;
import org.eclipse.reddeer.junit.requirement.matcher.RequirementMatcher;
import org.eclipse.reddeer.requirements.jre.JRERequirement.JRE;
import org.eclipse.reddeer.requirements.openperspective.OpenPerspectiveRequirement.OpenPerspective;
import org.eclipse.reddeer.requirements.server.ServerRequirementState;
import org.jboss.ide.eclipse.as.reddeer.server.family.ServerMatcher;
import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerRequirement.JBossServer;
import org.jboss.tools.cdi.bot.test.beans.qualifier.template.QualifierValidationQuickFixTemplate;
import org.jboss.tools.cdi.reddeer.validators.QualifierValidationProviderCDI11;
import org.junit.Before;

@JRE(cleanup=true)
@JBossServer(state=ServerRequirementState.PRESENT, cleanup=false)
@OpenPerspective(JavaEEPerspective.class)
public class QualifierValidationQuickFixTestCDI11 extends QualifierValidationQuickFixTemplate{

	@RequirementRestriction
	public static Collection<RequirementMatcher> getRestrictionMatcher() {
		if (isJavaLE8()) { 
			return Arrays.asList(new RequirementMatcher(JBossServer.class, FAMILY, ServerMatcher.WildFly()),
					new RequirementMatcher(JBossServer.class, VERSION, "13"));
		} else {
			return Arrays.asList(
					new RequirementMatcher(JBossServer.class, FAMILY, ServerMatcher.WildFly()),
					new RequirementMatcher(JBossServer.class, VERSION, "13"),
					new RequirementMatcher(JRE.class, VERSION, "1.8"));
		}
	}
	
	@Before
	public void changeDiscoveryMode(){
		validationProvider = new QualifierValidationProviderCDI11();
		prepareBeanXml("all", true);
		CDIVersion = "1.1";
	}

}
