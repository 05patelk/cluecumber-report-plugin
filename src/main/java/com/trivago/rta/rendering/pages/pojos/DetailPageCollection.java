/*
 * Copyright 2018 trivago N.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.trivago.rta.rendering.pages.pojos;

import com.trivago.rta.constants.Status;
import com.trivago.rta.json.pojo.Element;

public class DetailPageCollection {
    private Element element;
    private ReportDetails reportDetails;

    public DetailPageCollection(final Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public ReportDetails getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(final ReportDetails reportDetails) {
        this.reportDetails = reportDetails;
    }

    public int getTotalNumberOfSteps() {
        return element.getSteps().size();
    }

    public int getTotalNumberOfPassedSteps() {
        return getNumberOfStepsWithStatus(Status.PASSED);
    }

    public int getTotalNumberOfFailedSteps() {
        return getNumberOfStepsWithStatus(Status.FAILED) +
                getNumberOfStepsWithStatus(Status.UNDEFINED) +
                getNumberOfStepsWithStatus(Status.AMBIGUOUS);
    }

    public int getTotalNumberOfSkippedSteps() {
        return getNumberOfStepsWithStatus(Status.SKIPPED) + getNumberOfStepsWithStatus(Status.PENDING);
    }

    private int getNumberOfStepsWithStatus(final Status status) {
        return (int) element.getSteps().stream().filter(step -> step.getStatus() == status).count();
    }
}
