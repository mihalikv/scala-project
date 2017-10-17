/**
  * Created by Viliam on 17.10.2017.
  */
object PatternMatching extends App{
    abstract class Notification

    case class Email(sender: String, title: String, body: String) extends Notification

    case class SMS(caller: String, message: String) extends Notification

    case class VoiceRecording(contactName: String, link: String) extends Notification

    def showNotification(notification: Notification): String = {
        notification match {
            case Email(email, title, _) =>
                s"You got an email from $email with title: $title"
            case SMS(number, message) =>
                s"You got an SMS from $number! Message: $message"
            case VoiceRecording(name, link) =>
                s"you received a Voice Recording from $name! Click the link to hear it: $link"
        }
    }
    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

    println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?

    println(showNotification(someVoiceRecording))
}
