package ProjectA;
import java.util.*;

// Song class to store details about song
class Song {
    private String title;
    private String artist;
    private int playCount;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.playCount = 0;
    }

    public void play() {
        playCount++;
    }

    public int getPlayCount() {
        return playCount;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Plays: " + playCount;
    }
}

// Playlist class to manage the songs
class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Song added successfully.");
    }

    public void removeSong(String title) {
        songs.removeIf(song -> song.getTitle().equalsIgnoreCase(title));
        System.out.println("Song removed successfully.");
    }

    public void printAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs in the playlist.");
            return;
        }
        System.out.println("Playlist: " + name);
        System.out.println("All Songs:");
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    public void printSongsByPlays() {
        if (songs.isEmpty()) {
            System.out.println("No songs in the playlist.");
            return;
        }
        songs.sort((a, b) -> Integer.compare(b.getPlayCount(), a.getPlayCount()));
        System.out.println("Playlist: " + name);
        System.out.println("Songs sorted by play count:");
        for (Song song : songs) {
            System.out.println(song);
        }
    }
}

// Main class to run the program and menu
class MusicStreamingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        Playlist playlist = new Playlist(playlistName);

        while (true) {
            System.out.println("\nMusic Streaming Service:");
            System.out.println("1. Create new playlist");
            System.out.println("2. Add song");
            System.out.println("3. Remove song");
            System.out.println("4. Print all songs");
            System.out.println("5. Print songs by plays");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter playlist name: ");
                    playlistName = scanner.nextLine();
                    playlist = new Playlist(playlistName);
                    System.out.println("New playlist created: " + playlistName);
                    break;
                case 2:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;
                case 3:
                    System.out.print("Enter song title to remove: ");
                    String removeTitle = scanner.nextLine();
                    playlist.removeSong(removeTitle);
                    break;
                case 4:
                    playlist.printAllSongs();
                    break;
                case 5:
                    playlist.printSongsByPlays();
                    break;
                case 6:
                    System.out.println("Closing Program");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
