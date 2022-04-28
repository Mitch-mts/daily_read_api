package mts.mtech.dailyread.service.email;


import static com.google.common.base.Preconditions.checkArgument;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Mitchell Tawanda Severa
 * @created 06/11/2020 - 10:56 PM
 */

public class Notification {
    private final String subject;
    private final String sentBy;
    private final String body;
    private final Medium medium;
    private final String sentByPersonal;
    private final Set<String> recipients;
    private final Set<String> cc;
    private final Set<String> bcc;
    private final List<MultipartFile> attachments;
    private final Map<String, String> additionalData;

    private Notification(String subject, String body, Medium medium, String sentBy, String sentByPersonal,
                         Set<String> recipients, Set<String> cc, Set<String> bcc, List<MultipartFile> attachments,
                         Map<String, String> additionalData) {
        this.recipients = recipients;
        this.cc = Objects.isNull(cc) ? Collections.emptySet() : cc;
        this.bcc = Objects.isNull(bcc) ? Collections.emptySet() : bcc;
        this.attachments = Objects.isNull(attachments) ? Collections.emptyList() : attachments;
        this.additionalData = Objects.isNull(additionalData) ? Collections.emptyMap() : additionalData;
        Objects.requireNonNull(subject, "Subject cannot be null.");
        checkArgument(subject.length() <= 150, "Subject must contain not more than 150 characters");
        checkArgument(sentBy.length() <= 150, "Sent by must contain not more than 150 characters");
        Objects.requireNonNull(subject, "Body cannot be null.");
        Objects.requireNonNull(medium, "Medium cannot be null.");
        checkArgument(sentByPersonal.length() <= 150, "sentByPersonal must contain not more than 150 characters");
        checkArgument(!recipients.isEmpty(), "Recipients cannot be empty");
        this.subject = subject;
        this.body = body;
        this.medium = medium;
        this.sentBy = sentBy;
        this.sentByPersonal = sentByPersonal;
    }

    public static NotificationBuilder builder() {
        return new NotificationBuilder();
    }


    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public Medium getMedium() {
        return medium;
    }

    public Set<String> getRecipients() {
        return recipients;
    }

    public List<MultipartFile> getAttachments() {
        return attachments;
    }

    public String getSentBy() {
        return sentBy;
    }

    public String getSentByPersonal() {
        return sentByPersonal;
    }

    public Set<String> getCc() {
        return cc;
    }

    public Set<String> getBcc() {
        return bcc;
    }


    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "subject='" + subject + '\'' +
                ", sentBy='" + sentBy + '\'' +
                ", body='" + body + '\'' +
                ", medium=" + medium +
                ", sentByPersonal='" + sentByPersonal + '\'' +
                ", recipients=" + recipients +
                ", cc=" + cc +
                ", bcc=" + bcc +
                ", attachments=" + attachments +
                ", additionalData=" + additionalData +
                '}';
    }

    public static class NotificationBuilder {
        private String subject;
        private String body;
        private Medium medium;
        private String from;
        private String fromPersonal;
        private Set<String> recipients;
        private Set<String> cc;
        private Set<String> bcc;
        private List<MultipartFile> attachments;
        private Map<String, String> additionalData;

        private NotificationBuilder() {
        }

        public NotificationBuilder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public NotificationBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public NotificationBuilder setMedium(Medium medium) {
            this.medium = medium;
            return this;
        }

        public NotificationBuilder setFrom(String from) {
            this.from = from;
            return this;
        }

        public NotificationBuilder setFromPersonal(String fromPersonal) {
            this.fromPersonal = fromPersonal;
            return this;
        }

        public NotificationBuilder setRecipients(Set<String> recipients) {
            this.recipients = recipients;
            return this;
        }

        public NotificationBuilder setCc(Set<String> cc) {
            this.cc = cc;
            return this;
        }

        public NotificationBuilder setBcc(Set<String> bcc) {
            this.bcc = bcc;
            return this;
        }

        public NotificationBuilder setAttachments(List<MultipartFile> attachments) {
            this.attachments = attachments;
            return this;
        }

        public NotificationBuilder setAdditionalData(Map<String, String> additionalData) {
            this.additionalData = additionalData;
            return this;
        }

        public Notification build() {
            return new Notification(subject, body, medium, from, fromPersonal, recipients, cc, bcc, attachments,
                    additionalData);
        }
    }
}
